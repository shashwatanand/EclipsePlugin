package com.nashtech.hw.shashwat.app.ui.main;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public abstract class MainPartUI extends Composite {

	private Composite topComposite;
	private Text txtFile;
	private Button btnSelectFile;
	private Button btnLoadFile;

	public MainPartUI(final Composite parent, final int style) {
		super(parent, style);
	}
	
	protected void createUI(final IEclipseContext eclipseContext) {
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(this);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		createTopComp();
	}

	private void createTopComp() {
		this.topComposite = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(5).applyTo(this.topComposite);
		topComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		final Label lblLoadTupleFromFile = new Label(topComposite, SWT.NONE);
		lblLoadTupleFromFile.setText("Load Tuples from file");
		
		this.txtFile = new Text(this.topComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(SWT.FILL, SWT.CENTER).applyTo(this.txtFile);
		
		this.btnSelectFile = new Button(this.topComposite, SWT.PUSH);
		this.btnSelectFile.setText("Select File");
		this.btnLoadFile = new Button(this.topComposite, SWT.PUSH);
		this.btnLoadFile.setText("Load File");
	}
}
