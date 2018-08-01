package de.shashwat.eg.xviewer.ui;

import java.util.List;

import org.eclipse.nebula.widgets.xviewer.edit.CellEditDescriptor;
import org.eclipse.nebula.widgets.xviewer.edit.XViewerConverter;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import de.shashwat.eg.xviewer.model.Task;

/**
 * The Class CustomXViewerConverter.
 */
public class CustomXViewerConverter implements XViewerConverter {

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.edit.XViewerConverter#setInput(org.eclipse.swt.widgets.Control, org.eclipse.nebula.widgets.xviewer.edit.CellEditDescriptor, java.lang.Object)
	 */
	@Override
	public void setInput(Control c, CellEditDescriptor ced, Object selObject) {
		if (c instanceof Text) {
			Text text = (Text) c;
			if (selObject instanceof Task) {
				Task task = (Task) selObject;
				if ("completed".equals(ced.getInputField())) {
					text.setText(String.valueOf(task.getPercentComplete()));
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.edit.XViewerConverter#getInput(org.eclipse.swt.widgets.Control, org.eclipse.nebula.widgets.xviewer.edit.CellEditDescriptor, java.lang.Object)
	 */
	@Override
	public Object getInput(Control c, CellEditDescriptor ced, Object selObject) {
		if ("completed".equals(ced.getInputField())) {
			if (c instanceof Text) {
				Text text = (Text) c;
				Integer intValue = Integer.valueOf(text.getText());
				if (selObject instanceof Task) {
					Task task = (Task) selObject;
					task.setPercentComplete(intValue);
				} else if (selObject instanceof List<?>) {
					List<?> list = (List<?>) selObject;
					if (list.isEmpty()) {
						return null;
					}
					if (((Task) list.get(0)).getPercentComplete() == intValue) {
						return null;
					}
					for (Object o : list) {
						if (o instanceof Task) {
							Task task = (Task) o;
							task.setPercentComplete(intValue);
						}
					}
					return selObject;
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.edit.XViewerConverter#isValid(org.eclipse.nebula.widgets.xviewer.edit.CellEditDescriptor, java.lang.Object)
	 */
	@Override
	public boolean isValid(CellEditDescriptor ced, Object selObject) {
		return true;
	}

}
