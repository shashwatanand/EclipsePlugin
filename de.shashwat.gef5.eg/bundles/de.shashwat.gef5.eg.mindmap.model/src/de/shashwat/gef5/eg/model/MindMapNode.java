package de.shashwat.gef5.eg.model;

import java.io.Serializable;
import java.util.List;

import org.eclipse.gef.geometry.planar.Rectangle;

import com.google.common.collect.Lists;

import javafx.scene.paint.Color;

/**
 * The Class MindMapNode.
 */
public class MindMapNode extends AbstractItem implements Serializable {

	/**  Generated UUID. */
	private static final long serialVersionUID = 1338853491977459753L;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The color. */
	private Color color;
	
	/** The bounds. */
	private Rectangle bounds;
	
	/** The incoming connections. */
	private List<MindMapConnection> incomingConnections = Lists.newArrayList();
	
	/** The outgoing connections. */
	private List<MindMapConnection> outgoingConnections = Lists.newArrayList();
	
	/**
	 * Adds the incoming connection.
	 *
	 * @param conn the conn
	 */
	public void addIncomingConnection(MindMapConnection conn) {
		incomingConnections.add(conn);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_INCOMING_CONNECTIONS, null, conn);
	}

	/**
	 * Adds the outgoing connection.
	 *
	 * @param conn the conn
	 */
	public void addOutgoingConnection(MindMapConnection conn) {
		outgoingConnections.add(conn);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_OUTGOGING_CONNECTIONS, null, conn);
	}

	/**
	 * Gets the bounds.
	 *
	 * @return the bounds
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Gets the incoming connections.
	 *
	 * @return the incoming connections
	 */
	public List<MindMapConnection> getIncomingConnections() {
		return incomingConnections;
	}

	/**
	 * Gets the outgoing connections.
	 *
	 * @return the outgoing connections
	 */
	public List<MindMapConnection> getOutgoingConnections() {
		return outgoingConnections;
	}
	
	/**
	 * Sets the bounds.
	 *
	 * @param bounds the new bounds
	 */
	public void setBounds(Rectangle bounds) {
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_BOUNDS, this.bounds, (this.bounds = bounds.getCopy()));
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(Color color) {
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_COLOR, this.color, (this.color = color));
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_DESCRIPTION, this.description, (this.description = description));
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_TITLE, this.title, (this.title = title));
	}
	
	/**
	 * Removes the incoming connection.
	 *
	 * @param conn the conn
	 */
	public void removeIncomingConnection(MindMapConnection conn) {
		incomingConnections.remove(conn);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_INCOMING_CONNECTIONS, conn, null);
	}

	/**
	 * Removes the outgoing connection.
	 *
	 * @param conn the conn
	 */
	public void removeOutgoingConnection(MindMapConnection conn) {
		outgoingConnections.remove(conn);
		this.propertyChangeSupport.firePropertyChange(IConstants.PROP_OUTGOGING_CONNECTIONS, conn, null);
	}
}
