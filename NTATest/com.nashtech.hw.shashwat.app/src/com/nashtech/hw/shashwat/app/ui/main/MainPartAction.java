package com.nashtech.hw.shashwat.app.ui.main;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

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
	}
}
