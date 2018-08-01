package de.shashwat.eg.xviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.nebula.widgets.xviewer.util.XViewerDisplay;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.shashwat.eg.xviewer.images.XViewerImageCache;
import de.shashwat.eg.xviewer.model.ITask;
import de.shashwat.eg.xviewer.ui.CustomXViewer;
import de.shashwat.eg.xviewer.ui.DefaultCustomizations;

public class CustomXViewerTest {
	static CustomXViewer xviewer;

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
		xviewer = new CustomXViewer(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		xviewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createToolBar(toolBarComp);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private static void createToolBar(final Composite toolBarComp) {
		Composite comp = new Composite(toolBarComp, SWT.NONE);
		comp.setLayout(new GridLayout());
		comp.setLayoutData(new GridData(GridData.END));

		ToolBar toolBar = new ToolBar(comp, SWT.FLAT | SWT.RIGHT);
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).applyTo(toolBar);
		ToolItem refresh = new ToolItem(toolBar, SWT.PUSH);
		refresh.setImage(XViewerImageCache.getImage("refresh.gif"));
		refresh.setToolTipText("Refresh");

		refresh.addListener(SWT.Selection, e -> {
			List<Object> tasks = new ArrayList<Object>();
			for (int x = 0; x < 1; x++) {
				tasks.addAll(getSampleTasks());
			}
			xviewer.setInputXViewer(tasks);
		});

		Action dropDownAction = xviewer.getCustomizeAction();
		new ActionContributionItem(dropDownAction).fill(toolBar, 0);
		
		ToolItem description = new ToolItem(toolBar, SWT.PUSH);
		description.setImage(XViewerImageCache.getImage("descriptionView.gif"));
		description.setToolTipText("Description View");
		
		description.addListener(SWT.Selection, e -> {
			xviewer.getCustomizeMgr().loadCustomization(DefaultCustomizations.getDescriptionCustomization());
			xviewer.refresh();
		});
	}

	private static List<ITask> getSampleTasks() {
		return null;
	}
}
