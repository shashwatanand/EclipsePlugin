package com.nashtech.hw.shashwat.app.ui.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.swt.SWT;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.nashtech.hw.shashwat.app.exceptions.TupleNotInFormatException;
import com.nashtech.hw.shashwat.app.exceptions.TupleNotUniqueException;
import com.nashtech.hw.shashwat.app.model.Tuple;
import com.nashtech.hw.shashwat.app.provider.SearchResultProvider;
import com.nashtech.hw.shashwat.app.provider.TupleProvider;
import com.nashtech.hw.shashwat.app.ui.console.ConsoleUI;
import com.nashtech.hw.shashwat.app.ui.console.MessageType;
import com.nashtech.hw.shashwat.app.util.Constants;
import com.nashtech.hw.shashwat.app.util.Query;
import com.nashtech.hw.shashwat.app.util.Util;

/**
 * The Class MainPartAction.
 * 
 * @author shashwat.anand
 */
public class MainPartAction extends MainPartUI {
	/** The logger. */
	private final Logger logger = Logger.getLogger(MainPartAction.class.getSimpleName());
	
	/** {@link UISynchronize} instance. */
	@Inject
	private UISynchronize uiSynchronize;
	
	
	/** Member variable 'eclipse context' for {@link IEclipseContext}. */
	@Inject
	private IEclipseContext eclipseContext;
	
	/**
	 * Instantiates a new main part action.
	 *
	 * @param parent the parent
	 */
	@Inject
	public MainPartAction(final Composite parent) {
		super(parent, SWT.NONE);
	}
	
	/**
	 * Creates the UI.
	 */
	@PostConstruct
	private void createUI() {
		super.createUI(this.eclipseContext);
		init();
	}

	/**
	 * Inits the.
	 */
	private void init() {
		initTopComp();
		initBottomComp();
		initListeners();
		showQueryPanel(false);
	}

	/**
	 * Inits the bottom comp.
	 */
	private void initBottomComp() {
		final Query[] values = Query.values();
		final List<String> itemsList = new ArrayList<>();
		for (Query query : values) {
			itemsList.add(query.toString());
		}
		this.comboQuery.setItems(itemsList.toArray(new String[itemsList.size()]));
	}

	/**
	 * Inits the top comp.
	 */
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
	
	/**
	 * Inits the listeners.
	 */
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
				Util.getInstance().updateLogFile("Please select the valid text file which contains the tuples", MessageType.FAILURE);
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
						final Util instance = Util.getInstance();
						try {
							instance.getInMemTuples().clear();
							provider.loadTuplesForFile(fileStr, monitor);
							if (instance.getInMemTuples().size() > 0) {
								if (uiSynchronize != null) {
									uiSynchronize.asyncExec(new Runnable() {
										public void run() {
											showQueryPanel(true);
										}
									});
								}
							}
						} catch (TupleNotInFormatException e) {
							uiSynchronize.syncExec(new Runnable() {
								public void run() {
									showQueryPanel(false);
								}
							});
							instance.updateLogFile(e.getMessage(), MessageType.FAILURE);
						} catch (TupleNotUniqueException e) {
							uiSynchronize.syncExec(new Runnable() {
								public void run() {
									showQueryPanel(false);
								}
							});
							instance.updateLogFile(e.getMessage(), MessageType.FAILURE);
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
					txtQueryById.setText("");
					break;
				case SEARCH_BY_NAME:
					queryCompositeLayout.topControl = queryResultByNameComp;
					queryComposite.layout();
					txtQueryByName.setText("");
					break;
				case SEARCH_BY_PATTERN:
					queryCompositeLayout.topControl = queryResultByPatternComp;
					queryComposite.layout();
					txtQueryByPattern.setText("");
					break;
				case SEARCH_BY_FLAG:
					queryCompositeLayout.topControl = queryResultByFlagComp;
					queryComposite.layout();
					btnFlag.setSelection(false);
					break;
				default:
					break;
				}
				queryComposite.getParent().update();
			}
		});
		
		btnSearch.addListener(SWT.Selection, event -> {
			final Util instance = Util.getInstance();
			Map<Integer, Tuple> inMemTuples = instance.getInMemTuples();
			if (inMemTuples.isEmpty()) {
				instance.updateLogFile("No tuples in memory", MessageType.SUCCESS);
				return;
			}
			final String selectedText = this.comboQuery.getText();
			Query queryEnum = Query.getQueryEnum(selectedText);
			try {
				if (queryEnum != null) {
					SearchResultProvider provider = new SearchResultProvider();
					switch (queryEnum) {
					case SEARCH_BY_ID:
						searchById(instance, provider);
						break;
					case SEARCH_BY_NAME:
						searchByName(instance, provider);
						break;
					case SEARCH_BY_PATTERN:
						searchByPattern(instance, provider);
						break;
					case SEARCH_BY_FLAG:
						searchByFlag(instance, provider);
						break;
					default:
						break;
					}
				}
			} catch (Exception e) {
				instance.updateLogFile("Exception occured while searching ! " + e, MessageType.FAILURE);
			}
		});
		
		this.btnExport.addListener(SWT.Selection, event -> {
			Util instance = Util.getInstance();
			ConsoleUI consolePart;
			if ((consolePart = instance.getConsolePart()) != null) {
				final String messages = consolePart.getAllSuccessMessages();
				if (Util.isEmpty(messages)) {
					instance.updateLogFile("Unable to dump the queries as no success message are present", MessageType.FAILURE);
					return;
				}
				final Shell shell = this.getShell();
				final FileDialog dialog = new FileDialog(shell, SWT.SAVE);
				dialog.setText("Select file to dump queries");
				dialog.setFilterExtensions(Constants.FILTER_EXT);
				String selectedFileStr = dialog.open();
				if (Util.isEmpty(selectedFileStr)) {
					Util.getInstance().updateLogFile("Please select the valid file in you want to dump queries", MessageType.FAILURE);
					this.btnExport.setEnabled(true);
					return;
				}
				try {
					Files.write(Paths.get(selectedFileStr), messages.getBytes());
					Program.launch(selectedFileStr);
				} catch (IOException e) {
					logger.log(Level.SEVERE, "IOException occured while dumping queries in file ! " + e);
				}
			}
		});
	}

	/**
	 * Search by id.
	 *
	 * @param instance the instance
	 * @param provider the provider
	 * @throws NumberFormatException the number format exception
	 */
	private void searchById(final Util instance, SearchResultProvider provider) throws NumberFormatException {
		String searchText = txtQueryById.getText().trim();
		if (!Util.isInteger(searchText)) {
			instance.updateLogFile("Not valid integer", MessageType.FAILURE);
			return;
		}
		List<Tuple> results = provider.searchBasedOnId(Integer.parseInt(searchText));
		if (results.isEmpty()) {
			instance.updateLogFile("Query - list tuple based on Id - No tuple found - Entered Id : " + searchText, MessageType.FAILURE);
			return;
		}
		instance.updateLogFile("Query - list tuple based on Id - Entered Id : " + searchText, MessageType.SUCCESS);
		for (Tuple tuple : results) {
			instance.updateLogFile(tuple.toString(), MessageType.SUCCESS);
		}
	}
	
	/**
	 * Search by name.
	 *
	 * @param instance the instance
	 * @param provider the provider
	 */
	private void searchByName(final Util instance, SearchResultProvider provider) {
		String searchText = "\"" + txtQueryByName.getText().trim() + "\"" ;
		List<Tuple> results = provider.searchBasedOnName(searchText);
		if (results.isEmpty()) {
			instance.updateLogFile("Query - list tuple based on Name - No tuple found - Entered Name : " + searchText, MessageType.FAILURE);
			return;
		}
		instance.updateLogFile("Query - list tuple based on Name - Entered Name : " + searchText, MessageType.SUCCESS);
		for (Tuple tuple : results) {
			instance.updateLogFile(tuple.toString(), MessageType.SUCCESS);
		}
	}
	
	/**
	 * Search by pattern.
	 *
	 * @param instance the instance
	 * @param provider the provider
	 */
	private void searchByPattern(final Util instance, SearchResultProvider provider) {
		String searchText = txtQueryByPattern.getText().trim();
		List<Tuple> results = provider.searchBasedOnPattern(searchText);
		if (results.isEmpty()) {
			instance.updateLogFile("Query - list tuple based on Pattern - No tuple found - Entered Pattern : " + searchText, MessageType.FAILURE);
			return;
		}
		instance.updateLogFile("Query - list tuple based on Pattern - Entered Pattern : " + searchText, MessageType.SUCCESS);
		for (Tuple tuple : results) {
			instance.updateLogFile(tuple.toString(), MessageType.SUCCESS);
		}
	}
	
	/**
	 * Search by flag.
	 *
	 * @param instance the instance
	 * @param provider the provider
	 */
	private void searchByFlag(final Util instance, SearchResultProvider provider) {
		final boolean searchFlag = btnFlag.getSelection();
		List<Tuple> results = provider.searchBasedOnFlag(searchFlag);
		if (results.isEmpty()) {
			instance.updateLogFile("Query - list tuple based on flag - No tuple found - Entered flag : " + searchFlag, MessageType.FAILURE);
			return;
		}
		instance.updateLogFile("Query - list tuple based on flag - Entered flag : " + searchFlag, MessageType.SUCCESS);
		for (Tuple tuple : results) {
			instance.updateLogFile(tuple.toString(), MessageType.SUCCESS);
		}
	}
}
