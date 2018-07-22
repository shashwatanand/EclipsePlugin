package de.shashwat.gef5.eg.model;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * The Class SimpleMindMapItem.
 */
public class SimpleMindMapItem extends AbstractItem {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4502250340528031435L;
	
	/** The child elements. */
	private List<AbstractItem> childElements = Lists.newArrayList();
	
	/**
	 * Gets the child elements.
	 *
	 * @return the child elements
	 */
	public List<AbstractItem> getChildElements() {
		return childElements;
	}

	/**
	 * Adds the child element.
	 *
	 * @param node the node
	 */
	public void addChildElement(AbstractItem node) {
		childElements.add(node);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_CHILD_ELEMENTS, null, node);
	}
	
	/**
	 * Adds the child element.
	 *
	 * @param node the node
	 * @param index the index
	 */
	public void addChildElement(final AbstractItem node, int index) {
		childElements.add(index, node);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_CHILD_ELEMENTS, null, node);
	}
	
	/**
	 * Removes the child element.
	 *
	 * @param node the node
	 */
	public void removeChildElement(final AbstractItem node) {
		childElements.remove(node);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_CHILD_ELEMENTS, node, null);
	}
}
