
package com.nashtech.hw.shashwat.app.ui.console;

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

/**
 * The Class OutputPart.
 * 
 * @author shashwat.anand
 */
public class OutputPart {
	/** The logger. */
	private final Logger logger = Logger.getLogger(OutputPart.class.getSimpleName());

	/** Member variable 'eclipse context' for {@link IEclipseContext}. */
	@Inject
	private IEclipseContext eclipseContext;

	/** The console UI. */
	private ConsoleUI consoleUI;

	/**
	 * Method for Post construct.
	 *
	 * @param parent {@link Composite}
	 */
	@PostConstruct
	public void postConstruct(final Composite parent) {
		try {
			final GridLayout gridLayout = new GridLayout(1, false);
			parent.setLayout(gridLayout);
			parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			buildComponents(parent);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured at creating UI compoents!", e); //$NON-NLS-1$
		}
	}

	/**
	 * Method for Builds the components.
	 *
	 * @param parent {@link Composite}
	 */
	private void buildComponents(final Composite parent) {
		eclipseContext.set(Composite.class, parent);
		this.consoleUI = ContextInjectionFactory.make(ConsoleUI.class, eclipseContext);
	}

	/**
	 * Gets the console UI.
	 *
	 * @return the consoleUI
	 */
	public ConsoleUI getConsoleUI() {
		return consoleUI;
	}
}