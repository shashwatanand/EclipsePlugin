package com.nashtech.hw.shashwat.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.e4.ui.workbench.lifecycle.PreSave;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;
import org.eclipse.e4.ui.workbench.lifecycle.ProcessRemovals;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

/**
 * This is a stub implementation containing e4 LifeCycle annotated methods.<br />
 * There is a corresponding entry in <em>plugin.xml</em> (under the
 * <em>org.eclipse.core.runtime.products' extension point</em>) that references
 * this class.
 **/
@SuppressWarnings("restriction")
public class E4LifeCycle {
	/** The logger. */
	private final Logger logger = Logger.getLogger(E4LifeCycle.class.getSimpleName());

	/**
	 * Member to store default location of shell
	 */
	private Point defaultLocation;
	
	/**
	 * Post context create.
	 *
	 * @param workbenchContext the workbench context
	 */
	@PostContextCreate
	void postContextCreate(IEclipseContext workbenchContext) {
	}

	/**
	 * Pre save.
	 *
	 * @param workbenchContext the workbench context
	 */
	@PreSave
	void preSave(IEclipseContext workbenchContext) {
	}

	/**
	 * Process additions.
	 *
	 * @param workbenchContext the workbench context
	 */
	@ProcessAdditions
	void processAdditions(IEclipseContext workbenchContext) {
	}

	/**
	 * Process removals.
	 *
	 * @param workbenchContext the workbench context
	 */
	@ProcessRemovals
	void processRemovals(IEclipseContext workbenchContext) {
	}
	
	@Inject
	@Optional
	public void receiveActiveShell(@Named(IServiceConstants.ACTIVE_SHELL) final Shell shell) {
		try {
			if (shell != null) {
				if (this.defaultLocation == null) {
					final Display display = shell.getDisplay();
					final Monitor primary = display.getPrimaryMonitor();
					final Rectangle displayBounds = primary.getBounds();
					shell.setSize(displayBounds.width - 400, displayBounds.height - 200);
					final Point size = shell.getSize();
					this.defaultLocation = new Point((int) (displayBounds.width - size.x) / 2, (int) (displayBounds.height - size.y) / 2);
					shell.setLocation(this.defaultLocation);
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Execption ocuured in Active Shell", e); //$NON-NLS-1$
		}
	}
}
