package com.nashtech.hw.shashwat.app.ui.statusbar;

import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.core.runtime.jobs.ProgressProvider;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;

/**
 * The Class ProgressControl.
 */
public class ProgressControl {
	/** The sync. */
	private final UISynchronize sync;
	
	/** The progress bar label. */
	private Label progressBarLabel;
	
	/** The progress bar. */
	private ProgressBar progressBar;

	/** The progress bar composite. */
	private Composite progressBarComposite;

	/** The monitor. */
	private ProgressMonitor monitor;

	/** The parent composite. */
	private Composite parentComposite;
	
	/**
	 * Instantiates a new progress control.
	 *
	 * @param sync the sync
	 * @param parent the parent
	 */
	@Inject
	public ProgressControl(final UISynchronize sync, final Composite parent) {
		this.sync = Objects.requireNonNull(sync);
		this.parentComposite = parent;
	}

	/**
	 * Creates the controls.
	 *
	 * @param mainComposite the main composite
	 */
	@PostConstruct
	private void createControls(final Composite mainComposite) {
		this.progressBarComposite = new Composite(mainComposite, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.RIGHT, SWT.FILL).grab(false, true).applyTo(progressBarComposite);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(0, 0).spacing(0, 0).applyTo(progressBarComposite);
		
		this.progressBarLabel = new Label(progressBarComposite, SWT.NONE);
		this.progressBarLabel.setVisible(false);
		
		GridData gridDataForProgressBar = new GridData();
		gridDataForProgressBar.widthHint = 70;
		gridDataForProgressBar.horizontalAlignment = SWT.RIGHT;
		
		this.progressBar = new ProgressBar(progressBarComposite, SWT.SMOOTH);
		this.progressBar.setLayoutData(gridDataForProgressBar);
		this.progressBar.setVisible(false);
		
		this.monitor = new ProgressMonitor();

		Job.getJobManager().setProgressProvider(new ProgressProvider() {
			@Override
			public IProgressMonitor createMonitor(Job job) {
				if(job.isUser()) {
					return monitor.addJob(job);
				}
				return null;
			}
		});
	}
	
	/**
	 * The Class ProgressMonitor.
	 */
	public class ProgressMonitor extends NullProgressMonitor {
		/** The running tasks. */
		private long runningTasks = 0L;

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.NullProgressMonitor#beginTask(java.lang.String, int)
		 */
		@Override
		public void beginTask(final String name, final int totalWork) {
			sync.syncExec(new Runnable() {

				@Override
				public void run() {
					progressBarLabel.setText(name + "  ");
					progressBarLabel.setVisible(true);
					progressBar.setVisible(true);
					
					progressBarComposite.layout();
					progressBarComposite.getParent().layout();
					progressBarComposite.update();
					
					if (runningTasks <= 0) {
						// --- no task is running at the moment ---
						progressBar.setSelection(0);
						progressBar.setMaximum(totalWork);

					} else {
						// --- other tasks are running ---
						progressBar.setMaximum(progressBar.getMaximum() + totalWork);
					}

					runningTasks++;
					progressBar.setToolTipText("Currently running: " + runningTasks + "\nLast task: " + name);
				}
			});
		}

		/**
		 * Adds the job.
		 *
		 * @param job the job
		 * @return the i progress monitor
		 */
		public IProgressMonitor addJob(Job job) {
			if (job != null) {
				job.addJobChangeListener(new JobChangeAdapter() {
					@Override
					public void done(IJobChangeEvent event) {
						sync.syncExec(new Runnable() {

							@Override
							public void run() {
								runningTasks--;
								if (progressBar != null && !progressBar.isDisposed()) {
									if (runningTasks > 0) {
										// --- some tasks are still running ---
										progressBar.setToolTipText("Currently running: " + runningTasks);
									} else {
										// --- all tasks are done (a reset of
										// selection could also be done) ---
										progressBar.setToolTipText("Currently no background progress running.");
										progressBar.setVisible(false);
										progressBarLabel.setText("");
										progressBarLabel.setVisible(false);										
										
										progressBarComposite.layout();
										progressBarComposite.getParent().layout();
										progressBarComposite.update();		
									}
								}
							}
						});

						// clean-up
						event.getJob().removeJobChangeListener(this);
					}
				});
			}
			return this;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.NullProgressMonitor#worked(int)
		 */
		@Override
		public void worked(final int work) {
			sync.syncExec(new Runnable() {

				@Override
				public void run() {
					if (progressBar != null && !progressBar.isDisposed()) {
						progressBar.setSelection(progressBar.getSelection() + work);
					}
				}
			});
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.runtime.NullProgressMonitor#done()
		 */
		@Override
		public void done() {
			sync.syncExec(new Runnable() {

				@Override
				public void run() {
					if (progressBar != null && !progressBar.isDisposed()) {
						progressBar.setSelection(0);
					}
				}
			});
		}
	}

	/**
	 * Gets the parent composite.
	 *
	 * @return the parentComposite
	 */
	public Composite getParentComposite() {
		return parentComposite;
	}
}
