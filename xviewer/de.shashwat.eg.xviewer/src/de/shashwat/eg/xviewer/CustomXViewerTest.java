package de.shashwat.eg.xviewer;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.nebula.widgets.xviewer.util.XViewerDisplay;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.shashwat.eg.xviewer.ui.CustomXViewer;

public class CustomXViewerTest {
	static CustomXViewer xmviewer;

	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.SHELL_TRIM);
		shell.setText("Shashwat XViewer Test");
		shell.setBounds(0, 0, 1000, 600);
		shell.setLayout(new GridLayout());
		shell.setLayoutData(new GridData(GridData.FILL_BOTH 
				| GridData.HORIZONTAL_ALIGN_BEGINNING));
		
		Composite toolBarComp = new Composite(shell, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(toolBarComp);
		toolBarComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		XViewerDisplay.setStandaloneXViewer(true, display);
		xmviewer = new CustomXViewer(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		xmviewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
