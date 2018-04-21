package com.nashtech.hw.shashwat.app.ui.main;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.nashtech.hw.shashwat.app.provider.TupleProvider;
import com.nashtech.hw.shashwat.app.util.Constants;
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
		initListeners();
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
				provider.getTuples(fileStr);
			}
		});
	}
}
