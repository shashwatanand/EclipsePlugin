package de.shashwat.eg.xviewer.ui;

import org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData;
import org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn;

import de.shashwat.eg.xviewer.utils.UIUtil;

/**
 * The Class DefaultCustomizations.
 */
public class DefaultCustomizations {
	
	/**
	 * Gets the completion customization.
	 *
	 * @return the completion customization
	 */
	public static CustomizeData getCompletionCustomization() {
		CustomizeData data = new CustomizeData();
		data.setName("Name Status");
		// Each customization must have it's own guid
		data.setGuid(UIUtil.generateGuidStr());
		data.setNameSpace(CustomXViewerFactory.COLUMN_NAMESPACE);

		// Columns must be copied cause they each store their own manipulation data and
		// can be used
		// across multiple customizations.
		XViewerColumn nameColumn = CustomXViewerFactory.Name_Col.copy();
		nameColumn.setSortForward(true);
		nameColumn.setWidth(175);
		nameColumn.setShow(true);
		data.getColumnData().getColumns().add(nameColumn);

		XViewerColumn percentCol = CustomXViewerFactory.Completed_Col.copy();
		percentCol.setWidth(150);
		percentCol.setShow(true);

		data.getColumnData().getColumns().add(percentCol);
		return data;
	}

	/**
	 * Gets the description customization.
	 *
	 * @return the description customization
	 */
	public static CustomizeData getDescriptionCustomization() {
		CustomizeData data = new CustomizeData();
		data.setName("Name Description");
		data.setGuid(UIUtil.generateGuidStr());
		data.setNameSpace(CustomXViewerFactory.COLUMN_NAMESPACE);

		XViewerColumn descColumn = CustomXViewerFactory.Description.copy();
		descColumn.setShow(true);
		descColumn.setWidth(250);
		data.getColumnData().getColumns().add(descColumn);

		XViewerColumn nameColumn = CustomXViewerFactory.Name_Col.copy();
		nameColumn.setSortForward(true);
		nameColumn.setWidth(175);
		nameColumn.setShow(true);
		data.getColumnData().getColumns().add(nameColumn);

		return data;
	}
}
