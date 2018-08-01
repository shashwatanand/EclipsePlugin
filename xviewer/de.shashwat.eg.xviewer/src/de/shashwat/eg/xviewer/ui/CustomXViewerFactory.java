package de.shashwat.eg.xviewer.ui;

import org.eclipse.nebula.widgets.xviewer.XViewerFactory;
import org.eclipse.nebula.widgets.xviewer.core.model.SortDataType;
import org.eclipse.nebula.widgets.xviewer.core.model.XViewerAlign;
import org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn;
import org.eclipse.nebula.widgets.xviewer.edit.ExtendedViewerColumn;

public class CustomXViewerFactory extends XViewerFactory {

	public static final String COLUMN_NAMESPACE = "Shashwat.XViewer";

	public static XViewerColumn Run_Col = new XViewerColumn(COLUMN_NAMESPACE + ".run", "Run", 80, XViewerAlign.Left,
			true, SortDataType.String, false, null);

	public static XViewerColumn Name_Col = new XViewerColumn(COLUMN_NAMESPACE + ".name", "Name", 200, XViewerAlign.Left,
			true, SortDataType.String, false, null);
	
	public static ExtendedViewerColumn Completed_Col = new ExtendedViewerColumn(COLUMN_NAMESPACE + ".complete",
			"Percent Complete", 80, XViewerAlign.Left, true, SortDataType.Float, false, null);
	
	public static XViewerColumn Schedule_Time = new XViewerColumn(COLUMN_NAMESPACE + ".startTime", "Start Time", 40,
			XViewerAlign.Center, true, SortDataType.String, false, "Time this task will run");
	
	public static XViewerColumn Run_Db = new XViewerColumn(COLUMN_NAMESPACE + ".runDb", "Run DB", 80, XViewerAlign.Left,
			true, SortDataType.String, false, null);
	
	public static XViewerColumn Task_Type = new XViewerColumn(COLUMN_NAMESPACE + ".taskType", "Task Type", 80,
			XViewerAlign.Left, true, SortDataType.String, false, "This is the type of task");
	
	public static XViewerColumn Last_Run_Date = new XViewerColumn(COLUMN_NAMESPACE + ".lastRunDate", "Last Run", 120,
			XViewerAlign.Left, true, SortDataType.Date, false, "This is the last time it was run");
	
	public static XViewerColumn Category = new XViewerColumn(COLUMN_NAMESPACE + ".category", "Category", 80,
			XViewerAlign.Left, false, SortDataType.String, false, null);
	
	public static XViewerColumn Notification = new XViewerColumn(COLUMN_NAMESPACE + ".emailResults", "Email Results To",
			150, XViewerAlign.Left, true, SortDataType.String, false, "Email to send notifications to");
	
	public static XViewerColumn Description = new XViewerColumn(COLUMN_NAMESPACE + ".description", "Description", 300,
			XViewerAlign.Left, true, SortDataType.String, false, null);
	
	public static XViewerColumn Other_Description = new XViewerColumn(COLUMN_NAMESPACE + ".otherDescription",
			"Other Description", 75, XViewerAlign.Left, false, SortDataType.String, false, null);
	
	public static XViewerColumn Long_Column = new XViewerColumn(COLUMN_NAMESPACE + ".longColumn", "Long Values", 50,
			XViewerAlign.Left, false, SortDataType.Long, false, null);

	public CustomXViewerFactory() {
		super("Shashwat.XViewer");
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

}
