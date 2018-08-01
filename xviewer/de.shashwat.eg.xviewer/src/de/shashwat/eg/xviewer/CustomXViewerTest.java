package de.shashwat.eg.xviewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.nebula.widgets.xviewer.edit.DefaultXViewerControlFactory;
import org.eclipse.nebula.widgets.xviewer.edit.XViewerControlFactory;
import org.eclipse.nebula.widgets.xviewer.edit.XViewerConverter;
import org.eclipse.nebula.widgets.xviewer.edit.XViewerMultiEditAdapter;
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
import de.shashwat.eg.xviewer.model.ITask.RunDatabase;
import de.shashwat.eg.xviewer.model.ITask.TaskType;
import de.shashwat.eg.xviewer.model.Task;
import de.shashwat.eg.xviewer.ui.CustomXViewer;
import de.shashwat.eg.xviewer.ui.CustomXViewerContentProvider;
import de.shashwat.eg.xviewer.ui.CustomXViewerConverter;
import de.shashwat.eg.xviewer.ui.CustomXViewerFactory;
import de.shashwat.eg.xviewer.ui.CustomXViewerLabelProvider;
import de.shashwat.eg.xviewer.ui.DefaultCustomizations;

/**
 * The Class CustomXViewerTest.
 */
public class CustomXViewerTest {
	
	/** The xviewer. */
	static CustomXViewer xviewer;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
		
		xviewer.setContentProvider(new CustomXViewerContentProvider());
		xviewer.setLabelProvider(new CustomXViewerLabelProvider(xviewer));
		
		XViewerControlFactory controlFactory = new DefaultXViewerControlFactory();
		XViewerConverter converter = new CustomXViewerConverter();
		xviewer.setXViewerEditAdapter(new XViewerMultiEditAdapter(controlFactory, converter));

		createToolBar(toolBarComp);

		List<Object> tasks = new ArrayList<Object>();
		for (int x = 0; x < 1; x++) {
			tasks.addAll(getSampleTasks());
		}

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Creates the tool bar.
	 *
	 * @param toolBarComp the tool bar comp
	 */
	@SuppressWarnings("unchecked")
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
		
		ToolItem completion = new ToolItem(toolBar, SWT.PUSH);
		completion.setImage(XViewerImageCache.getImage("completionView.gif"));
		completion.setToolTipText("Completion View");
		
		completion.addListener(SWT.Selection, e -> {
			xviewer.getCustomizeMgr().loadCustomization(DefaultCustomizations.getCompletionCustomization());
			xviewer.refresh();
		});

		ToolItem refreshSingleColumn = new ToolItem(toolBar, SWT.PUSH);
		refreshSingleColumn.setImage(XViewerImageCache.getImage("columnRefresh.gif"));
		refreshSingleColumn.setToolTipText("Example of Refreshing a Single Column");
		
		refreshSingleColumn.addListener(SWT.Selection, e -> {
			List<Object> items = (List<Object>) xviewer.getInput();
			for (Object item : items) {
				Task task = (Task) item;
				task.setTaskType(TaskType.Refreshed);
			}
			
			String colId = CustomXViewerFactory.Task_Type.getId();
			xviewer.refreshColumn(colId);
		});
	}
	
	/**
	 * Gets the sample tasks.
	 *
	 * @return the sample tasks
	 */
	private static List<ITask> getSampleTasks() {
		 List<ITask> tasks = new ArrayList<ITask>();
	      Task task =
	         new Task(RunDatabase.Test_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test1", "10:03", "run to test this",
	            "Suite A", "mark@eclipse.com", 50, 50000);
	      tasks.add(task);

	      for (int x = 0; x < 5; x++) {
	         task.addChild(new Task(RunDatabase.Test_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test33", "10:03",
	            "run to test isit this - child " + x, "Suite A", "mark@eclipse.com", 50, 9223336854775807L));
	      }

	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Data_Exchange, new Date(), "org.eclipse.osee.test2", "9:22",
	         "run to test that", "Suite B", "john@eclipse.com", 0, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test4", "8:23",
	         "in this world", "Suite A", "john@eclipse.com", 50, 50000L));
	      tasks.add(new Task(RunDatabase.Test_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test3", "23:01",
	         "now is the time", "Suite B", "mike@eclipse.com", 30, 9223372036854775807L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Database_Health, new Date(), "org.eclipse.osee.test5", "7:32",
	         "may be never", "Suite A", "steve@eclipse.com", 10, 50000L));
	      tasks.add(new Task(RunDatabase.Test_Database, TaskType.Data_Exchange, new Date(), "org.eclipse.osee.test14", "6:11", "",
	         "Suite A", "steve@eclipse.com", 95, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test6", "5:13",
	         "run to test this", "Suite B", "john@eclipse.com", 80, 50000L));
	      tasks.add(new Task(RunDatabase.Test_Database, TaskType.Database_Health, new Date(), "org.eclipse.osee.test12", "23:15", "",
	         "Suite A", "mike@eclipse.com", 90, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test13", "4:01",
	         "run to test this", "Suite B", "steve@eclipse.com", 100, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Data_Exchange, new Date(), "org.eclipse.osee.test11", "3:16",
	         "run to test this", "Suite A", "steve@eclipse.com", 53, 50000000000L));
	      tasks.add(new Task(RunDatabase.Test_Database, TaskType.Backup, new Date(), "org.eclipse.osee.test10", "5:01",
	         "run to test this", "Suite C", "mike@eclipse.com", 0, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Data_Exchange, new Date(), "org.eclipse.osee.test9", "4:27",
	         "run to test this", "Suite C", "steve@eclipse.com", 90, 50000L));
	      tasks.add(new Task(RunDatabase.Production_Database, TaskType.Regression, new Date(), "org.eclipse.osee.test7", "2:37",
	         "run to test this", "Suite C", "john@eclipse.com", 20, 50000L));
	      int num = 10;
	      for (String str : Arrays.asList("Now", "Cat", "Dog", "Tree", "Bike", "Sun", "Moon", "Grass", "Can", "Car",
	         "Truck", "Block", "Earth", "Mars", "Venus", "Requirements visualization", "Requirements management",
	         "Feature management", "Modeling", "Design", "Project Management", "Change management",
	         "Configuration Management", "Software Information Management", "Build management", "Testing",
	         "Release Management", "Software Deployment", "Issue management", "Monitoring and reporting", "Workflow")) {
	         tasks.add(new Task(RunDatabase.Test_Database, TaskType.Database_Health, new Date(), "org.eclipse.osee." + str, "24:" + num++,
	            str + " will run to test this", "Suite C" + num++, str.toLowerCase().replaceAll(" ", ".") + "@eclipse.com",
	            20, 340000));
	      }
	      return tasks;
	}
}
