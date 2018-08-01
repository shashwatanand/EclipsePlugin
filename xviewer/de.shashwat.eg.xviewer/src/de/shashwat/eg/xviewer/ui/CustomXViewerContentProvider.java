package de.shashwat.eg.xviewer.ui;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.jface.viewers.ITreeContentProvider;

import de.shashwat.eg.xviewer.model.ITask;
import de.shashwat.eg.xviewer.model.Task;

/**
 * The Class CustomXViewerContentProvider.
 */
public class CustomXViewerContentProvider implements ITreeContentProvider {

	/** The root set. */
	protected Collection<ITask> rootSet = new HashSet<ITask>();

	/** The Constant EMPTY_ARRAY. */
	private final static Object[] EMPTY_ARRAY = new Object[0];

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof String) {
			return new Object[] { inputElement };
		}
		return getChildren(inputElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Object[]) {
			return (Object[]) parentElement;
		}
		if (parentElement instanceof Collection) {
			return ((Collection) parentElement).toArray();
		}
		if (parentElement instanceof Task) {
			return ((Task) parentElement).getChildren().toArray();
		}
		return EMPTY_ARRAY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Task) {
			return ((Task) element).getChildren().size() > 0;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// do nothing
	}

	/**
	 * Gets the root set.
	 *
	 * @return the root set
	 */
	public Collection<ITask> getRootSet() {
		return rootSet;
	}
}
