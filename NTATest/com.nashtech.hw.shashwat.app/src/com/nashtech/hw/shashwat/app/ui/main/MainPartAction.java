package com.nashtech.hw.shashwat.app.ui.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.nashtech.hw.shashwat.app.exceptions.TupleNotInFormatException;
import com.nashtech.hw.shashwat.app.exceptions.TupleNotUniqueException;
import com.nashtech.hw.shashwat.app.provider.TupleProvider;
import com.nashtech.hw.shashwat.app.ui.console.MessageType;
import com.nashtech.hw.shashwat.app.util.Constants;
import com.nashtech.hw.shashwat.app.util.Query;
import com.nashtech.hw.shashwat.app.util.Util;

public class MainPartAction extends MainPartUI {
	/** Member variable 'eclipse context' for {@link IEclipseContext}. */
	@Inject
	private IEclipseContext eclipseContext;
	
	@Inject
	public MainPartAction(final Composite parent) {
		super(parent, SWT.NONE);
	}
	
	@PostConstruct
	private void createUI() {
		super.createUI(this.eclipseContext);
		init();
	}

	private void init() {
		initTopComp();
		initBottomComp();
		initListeners();
	}

	private void initBottomComp() {
		final Query[] values = Query.values();
		final List<String> itemsList = new ArrayList<>();
		for (Query query : values) {
			itemsList.add(query.toString());
		}
		this.comboQuery.setItems(itemsList.toArray(new String[itemsList.size()]));
	}

	private void initTopComp() {
		this.btnLoadFile.setEnabled(false);
		final String inputFileStr = Util.getInstance().getInputFile();
		if (!Util.isEmpty(inputFileStr)) {
			final File inputFile = new File(inputFileStr);
			if (inputFile.exists()) {
				this.txtFile.setText(inputFile.getAbsolutePath());
				this.btnLoadFile.setEnabled(true);
				this.btnLoadFile.setFocus();
			} else {
				this.txtFile.setText("");
				this.btnLoadFile.setEnabled(false);
				this.btnSelectFile.setFocus();
			}
		}
	}
	
	private void initListeners() {
		this.btnSelectFile.addListener(SWT.Selection, event -> {
			final Shell shell = this.getShell();
			final FileDialog dialog = new FileDialog(shell, SWT.OPEN);
			dialog.setText("Select valid text file with tuples");
			// bug in eclipse https://bugs.eclipse.org/bugs/show_bug.cgi?id=426849
			dialog.setFilterPath(Util.getInstance().getInstalledFileLocationStr());
			dialog.setFilterExtensions(Constants.FILTER_EXT);
			String selectedFileStr = dialog.open();
			if (Util.isEmpty(selectedFileStr)) {
				MessageDialog.openError(shell, "Error", "Please select the valid text file which contains the tuples");
				this.btnLoadFile.setEnabled(false);
				this.btnSelectFile.setFocus();
				return;
			}
			this.txtFile.setText(selectedFileStr);
			this.btnLoadFile.setEnabled(true);
			this.btnLoadFile.setFocus();
		});
		
		this.btnLoadFile.addListener(SWT.Selection, event -> {
			String fileStr = txtFile.getText().trim();
			if (!Util.isEmpty(fileStr)) {
				TupleProvider provider = new TupleProvider();
				Job loadTuplesJob = new Job("Load Tuple From File....") {
					
					@Override
					protected IStatus run(IProgressMonitor monitor) {
						if (monitor.isCanceled()) {
							return Status.CANCEL_STATUS;
						}
						try {
							provider.loadTuplesForFile(fileStr, monitor);
							if (Util.getInstance().getInMemTuples().size() > 0) {
								showQueryPanel();
							}
						} catch (TupleNotInFormatException e) {
							Util.getInstance().updateLogFile(e.getMessage(), MessageType.FAILURE);
						} catch (TupleNotUniqueException e) {
							Util.getInstance().updateLogFile(e.getMessage(), MessageType.FAILURE);
						}
						return Status.OK_STATUS;
					}
				};
				loadTuplesJob.setUser(true);
				loadTuplesJob.schedule();
			}
		});
		
		this.comboQuery.addListener(SWT.Selection, event -> {
			final String selectedText = this.comboQuery.getText();
			Query queryEnum = Query.getQueryEnum(selectedText);
			if (queryEnum != null) {
				switch (queryEnum) {
				case SEARCH_BY_ID:
					queryCompositeLayout.topControl = queryResultByIdComp;
					queryComposite.layout();
					break;
				case SEARCH_BY_NAME:
					queryCompositeLayout.topControl = queryResultByNameComp;
					queryComposite.layout();
					break;
				case SEARCH_BY_PATTERN:
					queryCompositeLayout.topControl = queryResultByPatternComp;
					queryComposite.layout();
					break;
				case SEARCH_BY_FLAG:
					queryCompositeLayout.topControl = queryResultByFlagComp;
					queryComposite.layout();
					break;
				default:
					break;
				}
				queryComposite.getParent().update();
			}
		});
	}
}
