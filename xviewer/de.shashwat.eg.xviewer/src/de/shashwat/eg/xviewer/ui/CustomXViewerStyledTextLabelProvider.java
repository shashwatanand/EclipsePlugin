package de.shashwat.eg.xviewer.ui;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider;
import org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;

import de.shashwat.eg.xviewer.images.XViewerImageCache;
import de.shashwat.eg.xviewer.model.ITask;

/**
 * The Class CustomXViewerStyledTextLabelProvider.
 */
public class CustomXViewerStyledTextLabelProvider extends XViewerStyledTextLabelProvider {

	/** The viewer. */
	private final CustomXViewer viewer;

	/**
	 * Instantiates a new custom X viewer styled text label provider.
	 *
	 * @param viewer the viewer
	 */
	public CustomXViewerStyledTextLabelProvider(final CustomXViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider#getColumnImage(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public Image getColumnImage(Object element, XViewerColumn xCol, int column) throws Exception {
		if (xCol.equals(CustomXViewerFactory.Run_Col)) {
			return this.viewer.isRun((ITask) element) ? XViewerImageCache.getImage("chkbox_enabled.gif")
					: XViewerImageCache.getImage("chkbox_disabled.gif");
		}
		if (xCol.equals(CustomXViewerFactory.Name_Col) && this.viewer.isScheduled((ITask) element)) {
			return XViewerImageCache.getImage("clock.gif");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider#getStyledText(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public StyledString getStyledText(Object element, XViewerColumn xCol, int column) throws Exception {
		if (element instanceof String) {
			if (column == 1) {
				return new StyledString((String) element);
			} else {
				return new StyledString("");
			}
		}
		ITask task = ((ITask) element);
		if (task == null) {
			return new StyledString("");
		}
		if (xCol.equals(CustomXViewerFactory.Run_Col)) {
			return new StyledString(String.valueOf(this.viewer.isRun(task)), StyledString.COUNTER_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Name_Col)) {
			return new StyledString(task.getId(), StyledString.DECORATIONS_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Schedule_Time)) {
			return new StyledString(task.getStartTime(), StyledString.QUALIFIER_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Run_Db)) {
			return new StyledString(task.getRunDatabase().name(), StyledString.COUNTER_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Task_Type)) {
			return new StyledString(task.getTaskType().name(), StyledString.DECORATIONS_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Description)) {
			return new StyledString(task.getDescription(), StyledString.COUNTER_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Category)) {
			return new StyledString(task.getCategory(), StyledString.DECORATIONS_STYLER);
		}
		if (xCol.equals(CustomXViewerFactory.Notification)) {
			return new StyledString(task.getEmailAddress(), StyledString.QUALIFIER_STYLER);
		}
		return new StyledString("unhandled column");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider#getBackground(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public Color getBackground(Object element, XViewerColumn viewerColumn, int columnIndex) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider#getForeground(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public Color getForeground(Object element, XViewerColumn viewerColumn, int columnIndex) throws Exception {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerStyledTextLabelProvider#getFont(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public Font getFont(Object element, XViewerColumn viewerColumn, int columnIndex) throws Exception {
		return null;
	}

}
