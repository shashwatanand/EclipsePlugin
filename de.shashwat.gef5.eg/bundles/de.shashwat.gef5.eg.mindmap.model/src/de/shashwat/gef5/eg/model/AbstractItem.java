package de.shashwat.gef5.eg.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Abstract class for model item. 
 * This class has {@link PropertyChangeSupport} for all model items
 *
 * @author shashwat.anand
 */
public class AbstractItem implements Serializable {

	/**  Generated UUID. */
	private static final long serialVersionUID = -5816938591966465707L;
	
	/** The property change support. */
	protected PropertyChangeSupport propertyChangeSupport;
	
	/**
	 * Instantiates a new abstract item.
	 */
	public AbstractItem() {
		this.propertyChangeSupport = new PropertyChangeSupport(this);
	}
	
	/**
	 * Adds the property change listener.
	 *
	 * @param listener the listener
	 */
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	/**
	 * Removes the property change listener.
	 *
	 * @param listener the listener
	 */
	public void removePropertyChangeListener(final PropertyChangeListener listener) {
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}
}
