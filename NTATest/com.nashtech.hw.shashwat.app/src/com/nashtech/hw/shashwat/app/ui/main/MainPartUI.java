package com.nashtech.hw.shashwat.app.ui.main;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The Class MainPartUI.
 * 
 * @author shashwat.anand
 */
public abstract class MainPartUI extends Composite {

	/** The txt file. */
	protected Text txtFile;
	
	/** The btn select file. */
	protected Button btnSelectFile;
	
	/** The btn load file. */
	protected Button btnLoadFile;
	
	/** The query composite. */
	protected Composite queryComposite;
	
	/** The query composite layout. */
	protected StackLayout queryCompositeLayout;
	
	/** The combo query. */
	protected Combo comboQuery;
	
	/** The query result by id comp. */
	protected Composite queryResultByIdComp;
	
	/** The query result by name comp. */
	protected Composite queryResultByNameComp;
	
	/** The query result by pattern comp. */
	protected Composite queryResultByPatternComp;
	
	/** The query result by flag comp. */
	protected Composite queryResultByFlagComp;
	
	/** The txt query by name. */
	protected Text txtQueryByName;
	
	/** The txt query by id. */
	protected Text txtQueryById;
	
	/** The txt query by pattern. */
	protected Text txtQueryByPattern;
	
	/** The btn search. */
	protected Button btnSearch;
	
	/** The btn export. */
	protected Button btnExport;
	
	/** The btn flag. */
	protected Button btnFlag;
	
	/** The bottom comp. */
	private Composite bottomComp;

	/**
	 * Instantiates a new main part UI.
	 *
	 * @param parent the parent
	 * @param style the style
	 */
	public MainPartUI(final Composite parent, final int style) {
		super(parent, style);
	}
	
	/**
	 * Creates the UI.
	 *
	 * @param eclipseContext the eclipse context
	 */
	protected void createUI(final IEclipseContext eclipseContext) {
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(this);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createTopComp();
		createBottomComposite();
		this.getShell().setDefaultButton(this.btnSearch);
	}

	/**
	 * Creates the top comp.
	 */
	private void createTopComp() {
		final Composite topComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(5).applyTo(topComposite);
		topComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		final Label lblLoadTupleFromFile = new Label(topComposite, SWT.NONE);
		lblLoadTupleFromFile.setText("Load Tuples from file");
		
		this.txtFile = new Text(topComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(SWT.FILL, SWT.CENTER).applyTo(this.txtFile);
		this.txtFile.setEditable(false);
		
		this.btnSelectFile = new Button(topComposite, SWT.PUSH);
		this.btnSelectFile.setText("Select File");
		this.btnLoadFile = new Button(topComposite, SWT.PUSH);
		this.btnLoadFile.setText("Load File");
	}
	
	/**
	 * Creates the bottom composite.
	 */
	private void createBottomComposite() {
		this.bottomComp = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(bottomComp);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(bottomComp);
		
		Label lblSelectQuery = new Label(this.bottomComp, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(lblSelectQuery);
		lblSelectQuery.setText("Select query");
		this.comboQuery = new Combo(this.bottomComp, SWT.BORDER | SWT.READ_ONLY);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.CENTER).applyTo(this.comboQuery);
		
		createQueryPanel(bottomComp);
		createButtonBar(bottomComp);
	}
	
	/**
	 * Creates the query panel.
	 *
	 * @param parent the parent
	 */
	private void createQueryPanel(final Composite parent) {
		this.queryComposite = new Composite(parent, SWT.NONE);
		this.queryCompositeLayout = new StackLayout();
		this.queryComposite.setLayout(this.queryCompositeLayout);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).align(SWT.FILL, SWT.FILL).applyTo(this.queryComposite);
		
		createQueryByIdComp();
		
		createQueryByNameComp();
		
		createQueryByPatternComp();
		
		createQueryByFlagComp();
	}

	/**
	 * Creates the button bar.
	 *
	 * @param parent the parent
	 */
	private void createButtonBar(final Composite parent) {
		Composite buttonBarComp = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(buttonBarComp);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).span(2, 1).applyTo(buttonBarComp);
		
		this.btnSearch = new Button(buttonBarComp, SWT.PUSH);
		this.btnSearch.setText("Search");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(this.btnSearch);
		this.btnExport = new Button(buttonBarComp, SWT.PUSH);
		this.btnExport.setText("Dump results to file");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.LEFT, SWT.CENTER).applyTo(this.btnExport);
	}

	/**
	 * Creates the query by flag comp.
	 */
	private void createQueryByFlagComp() {
		this.queryResultByFlagComp = new Composite(this.queryComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(this.queryResultByFlagComp);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(this.queryResultByFlagComp);
		
		final Label lblQueryByFlag = new Label(this.queryResultByFlagComp, SWT.NONE);
		lblQueryByFlag.setText("list all pattern calls which are skipped/not skipped");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(lblQueryByFlag);
		
		this.btnFlag = new Button(this.queryResultByFlagComp, SWT.CHECK);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(this.btnFlag);
	}

	/**
	 * Creates the query by pattern comp.
	 */
	private void createQueryByPatternComp() {
		this.queryResultByPatternComp = new Composite(this.queryComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(true).applyTo(this.queryResultByPatternComp);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(this.queryResultByPatternComp);
		addEmptyFillingLabel(this.queryResultByPatternComp);
		
		final Label lblQueryByPattern = new Label(this.queryResultByPatternComp, SWT.NONE);
		lblQueryByPattern.setText("List all pattern calls with a specified path");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(lblQueryByPattern);
		
		this.txtQueryByPattern = new Text(this.queryResultByPatternComp, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.CENTER).hint(200, SWT.DEFAULT).applyTo(this.txtQueryByPattern);
		
		addEmptyFillingLabel(this.queryResultByPatternComp);
	}

	/**
	 * Creates the query by name comp.
	 */
	private void createQueryByNameComp() {
		this.queryResultByNameComp = new Composite(this.queryComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(true).applyTo(this.queryResultByNameComp);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(this.queryResultByNameComp);
		addEmptyFillingLabel(this.queryResultByNameComp);
		
		final Label lblQueryByName = new Label(this.queryResultByNameComp, SWT.NONE);
		lblQueryByName.setText("List all pattern calls with a specified name");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(lblQueryByName);
		
		this.txtQueryByName = new Text(this.queryResultByNameComp, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.CENTER).hint(200, SWT.DEFAULT).applyTo(this.txtQueryByName);
		addEmptyFillingLabel(this.queryResultByNameComp);
	}

	/**
	 * Creates the query by id comp.
	 */
	private void createQueryByIdComp() {
		this.queryResultByIdComp = new Composite(this.queryComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(true).applyTo(this.queryResultByIdComp);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.CENTER).applyTo(this.queryResultByIdComp);
		addEmptyFillingLabel(this.queryResultByIdComp);
		
		final Label lblQueryById = new Label(this.queryResultByIdComp, SWT.NONE);
		lblQueryById.setText("List all pattern calls with a specified Id");
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.RIGHT, SWT.CENTER).applyTo(lblQueryById);
		
		this.txtQueryById = new Text(this.queryResultByIdComp, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(false, false).align(SWT.LEFT, SWT.CENTER).hint(200, SWT.DEFAULT).applyTo(this.txtQueryById);
		
		addEmptyFillingLabel(this.queryResultByIdComp);
	}
	
	/**
	 * Adds the empty filling label.
	 *
	 * @param comp the comp
	 */
	private void addEmptyFillingLabel(Composite comp) {
		final Label lblEmpty = new Label(comp, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(lblEmpty);
	}

	/**
	 * Gets the query composite layout.
	 *
	 * @return the queryCompositeLayout
	 */
	public StackLayout getQueryCompositeLayout() {
		return queryCompositeLayout;
	}

	/**
	 * Show query panel.
	 *
	 * @param isVisible the is visible
	 */
	protected void showQueryPanel(final boolean isVisible) {
		this.bottomComp.setVisible(isVisible);
	}
}
