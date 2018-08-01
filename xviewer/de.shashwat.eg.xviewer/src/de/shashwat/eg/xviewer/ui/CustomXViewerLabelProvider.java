package de.shashwat.eg.xviewer.ui;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.nebula.widgets.xviewer.XViewerLabelProvider;
import org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn;
import org.eclipse.swt.graphics.Image;

import de.shashwat.eg.xviewer.images.XViewerImageCache;
import de.shashwat.eg.xviewer.model.ITask;

/**
 * The Class CustomXViewerLabelProvider.
 */
public class CustomXViewerLabelProvider extends XViewerLabelProvider {

	/** The viewer. */
	private final CustomXViewer viewer;

	/**
	 * Instantiates a new custom X viewer label provider.
	 *
	 * @param viewer the viewer
	 */
	public CustomXViewerLabelProvider(final CustomXViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
		// nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// nothing
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		// nothing

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerLabelProvider#getColumnImage(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public Image getColumnImage(Object element, XViewerColumn xCol, int columnIndex) throws Exception {
		if (xCol.equals(CustomXViewerFactory.Run_Col)) {
			return this.viewer.isRun((ITask) element) ? XViewerImageCache.getImage("chkbox_enabled.gif")
					: XViewerImageCache.getImage("chkbox_disabled.gif");
		}
		if (xCol.equals(CustomXViewerFactory.Name_Col) && viewer.isScheduled((ITask) element)) {
			return XViewerImageCache.getImage("clock.gif");
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.XViewerLabelProvider#getColumnText(java.lang.Object, org.eclipse.nebula.widgets.xviewer.core.model.XViewerColumn, int)
	 */
	@Override
	public String getColumnText(Object element, XViewerColumn xCol, int columnIndex) throws Exception {
		if (element instanceof String) {
			if (columnIndex == 1) {
				return (String) element;
			} else {
				return "";
			}
		}
		ITask task = ((ITask) element);
		if (task == null) {
			return "";
		}
		if (xCol.equals(CustomXViewerFactory.Run_Col)) {
			return String.valueOf(this.viewer.isRun(task));
		}
		if (xCol.equals(CustomXViewerFactory.Name_Col)) {
			return task.getId();
		}
		if (xCol.equals(CustomXViewerFactory.Schedule_Time)) {
			return task.getStartTime();
		}
		if (xCol.equals(CustomXViewerFactory.Run_Db)) {
			return task.getRunDatabase().name();
		}
		if (xCol.equals(CustomXViewerFactory.Task_Type)) {
			return task.getTaskType().name();
		}
		if (xCol.equals(CustomXViewerFactory.Description)) {
			return task.getDescription();
		}
		if (xCol.equals(CustomXViewerFactory.Category)) {
			return task.getCategory();
		}
		if (xCol.equals(CustomXViewerFactory.Notification)) {
			return task.getEmailAddress();
		}
		if (xCol.equals(CustomXViewerFactory.Last_Run_Date)) {
			return task.getLastRunDateStr();
		}
		if (xCol.equals(CustomXViewerFactory.Completed_Col)) {
			return String.valueOf(task.getPercentComplete());
		}
		if (xCol.equals(CustomXViewerFactory.Long_Column)) {
			return String.valueOf(task.getLongValue());
		}
		return "unhandled column";
	}

}
