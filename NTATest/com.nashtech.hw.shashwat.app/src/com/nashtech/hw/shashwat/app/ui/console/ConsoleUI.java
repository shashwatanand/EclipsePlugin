package com.nashtech.hw.shashwat.app.ui.console;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.nashtech.hw.shashwat.app.util.Constants;

/**
 * The Class ConsoleUI.
 * 
 * @author shashwat.anand
 */
public class ConsoleUI extends Composite {

	/** Logger instance. */
	private final Logger logger = Logger.getLogger(ConsoleUI.class.getSimpleName());

	/** {@link UISynchronize} instance. */
	@Inject
	private UISynchronize uiSynchronize;

	/** The style text. */
	private StyledText styleText;
	
	/** The success message builder. */
	private StringBuilder successMessageBuilder;

	/**
	 * Constructor.
	 *
	 * @param parent the parent
	 */
	@Inject
	public ConsoleUI(final Composite parent) {
		super(parent, SWT.NONE);
		this.successMessageBuilder = new StringBuilder();
	}

	/**
	 * Creates the UI.
	 */
	@PostConstruct
	private void createUI() {
		final GridLayout gridLayout = new GridLayout(1, false);
		this.setLayout(gridLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initUI();
	}

	/**
	 * Gets the event.
	 *
	 * @param message the message
	 * @return the event
	 */
	@Inject
	@Optional
	public void getEvent(@UIEventTopic(Constants.CONSOLE_MESSAGE) final ConsoleLogObj message) {
		updateInterface(message);
	}

	/**
	 * Update interface.
	 *
	 * @param message the message
	 */
	private void updateInterface(final ConsoleLogObj message) {
		try {
			this.uiSynchronize.syncExec(new Runnable() {
				@Override
				public void run() {
					try {
						if (!styleText.isDisposed()) {
							setLiveData(message);
						}
					} catch (Exception exc) {
						logger.log(Level.SEVERE, "Exception occured while setting script live mesaage text", exc); //$NON-NLS-1$
					}
				}
			});
		} catch (Exception exception) {
			logger.log(Level.SEVERE, "Exception occured while setting script live message text in update interface method", //$NON-NLS-1$
					exception);
		}
	}

	/**
	 * Method for Inits the UI.
	 */
	private void initUI() {
		this.styleText = new StyledText(this, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		this.styleText.setTextLimit(10);
		styleText.setBounds(10, 10, 100, 100);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).applyTo(styleText);
		styleText.setEditable(false);
		styleText.setBackground(styleText.getDisplay().getSystemColor(SWT.COLOR_WHITE));
	}

	
	/**
	 * Sets the live data.
	 *
	 * @param log the new live data
	 */
	private void setLiveData(final ConsoleLogObj log) {
		Display display = styleText.getDisplay();
		Color successCol = display.getSystemColor(SWT.COLOR_DARK_GREEN);
		Color failureCol = display.getSystemColor(SWT.COLOR_RED);
		String currentText = this.styleText.getText();
		String logStr = log.getLogStr();
		
		this.styleText.append(logStr);
		this.styleText.setTextLimit(20);
		this.styleText.setCaretOffset(this.styleText.getText().length());
		this.styleText.setTopIndex(this.styleText.getLineCount() - 1);

		StyleRange styleRange = new StyleRange();
		styleRange.start = currentText.length();
		styleRange.length = logStr.length();
		if (log.getMessageType() == MessageType.SUCCESS) {
			styleRange.foreground = successCol;
			this.successMessageBuilder.append(logStr);
		} else if (log.getMessageType() == MessageType.FAILURE) {
			styleRange.foreground = failureCol;
		}
		this.styleText.setStyleRange(styleRange);
		
	}
	
	/**
	 * Gets the all success messages.
	 *
	 * @return the all success messages
	 */
	public String getAllSuccessMessages() {
		return this.successMessageBuilder.toString();
	}
}
