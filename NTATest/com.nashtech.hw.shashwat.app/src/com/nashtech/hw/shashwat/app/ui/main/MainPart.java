 
package com.nashtech.hw.shashwat.app.ui.main;

import javax.inject.Inject;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


public class MainPart {
	
	/** The logger. */
	private final Logger logger = Logger.getLogger(MainPart.class.getSimpleName());
	
	/** The eclipse context. */
	@Inject
	private IEclipseContext eclipseContext;

	private MainPartAction mainPartAction;
	
	
	@PostConstruct
	public void postConstruct(final Composite parent) {
		try {
			parent.setLayout(new GridLayout(1, false));
			parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			buildComponents(parent);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured at creating UI compoents!", e); //$NON-NLS-1$
		}
	}


	private void buildComponents(Composite parent) {
		eclipseContext.set(Composite.class, parent);
		this.mainPartAction = ContextInjectionFactory.make(MainPartAction.class, eclipseContext);
	}


	/**
	 * @return the mainPartAction
	 */
	public MainPartAction getMainPartAction() {
		return mainPartAction;
	}
}