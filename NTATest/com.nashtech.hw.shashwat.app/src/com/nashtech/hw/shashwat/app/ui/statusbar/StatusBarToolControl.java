package com.nashtech.hw.shashwat.app.ui.statusbar;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


public class StatusBarToolControl extends Composite {
	/** {@link UISynchronize} instance. */
	@Inject
	private UISynchronize uiSynchronize;
	/** Member variable for {@link IEclipseContext}. */
	@Inject
	private IEclipseContext eclipseContext;
	private ProgressControl progressControl;
	
	@Inject
	public StatusBarToolControl(final Composite parent) {
		super(parent, SWT.BORDER);
	}

	
	@PostConstruct
	public void createGui() {
		GridLayoutFactory.fillDefaults()/*.spacing(0, 0).margins(0, 0).extendedMargins(0, 0, 0, 0)*/
				.applyTo(this.getParent());
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)/*.spacing(0, 0).margins(0, 0)
				.extendedMargins(0, 0, 0, 0)*/.applyTo(this);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(this);
		
		final Composite statusComposite = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(statusComposite);
		
		eclipseContext.set(UISynchronize.class, uiSynchronize);
		eclipseContext.set(Composite.class, this);
		this.progressControl = ContextInjectionFactory.make(ProgressControl.class, eclipseContext);
	}


	/**
	 * @return the progressControl
	 */
	public ProgressControl getProgressControl() {
		return progressControl;
	}
}