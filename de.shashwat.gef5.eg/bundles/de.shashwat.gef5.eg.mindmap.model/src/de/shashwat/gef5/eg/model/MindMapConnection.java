package de.shashwat.gef5.eg.model;

/**
 * The Class MindMapConnection.
 */
public class MindMapConnection extends AbstractItem {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7738915374861433533L;
	
	/** The source. */
	private MindMapNode source;
	
	/** The target. */
	private MindMapNode target;
	
	/** The connected. */
	private boolean connected;

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public MindMapNode getSource() {
		return source;
	}

	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public MindMapNode getTarget() {
		return target;
	}
	
	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(MindMapNode source) {
		this.source = source;
	}

	/**
	 * Sets the target.
	 *
	 * @param target the new target
	 */
	public void setTarget(MindMapNode target) {
		this.target = target;
	}
	
	/**
	 * Connect.
	 *
	 * @param source the source
	 * @param target the target
	 */
	public void connect(MindMapNode source, MindMapNode target) {
		if (source == null || target == null || source == target) {
			throw new IllegalArgumentException();
		}
		disconnect();
		this.source = source;
		this.target = target;
		reconnect();
	}
	
	/**
	 * Disconnect.
	 */
	public void disconnect() {
		if (connected) {
			source.removeOutgoingConnection(this);
			target.removeIncomingConnection(this);
			connected = false;
		}
	}
	
	/**
	 * Reconnect.
	 */
	public void reconnect() {
		if (!connected) {
			source.addOutgoingConnection(this);
			target.addIncomingConnection(this);
			connected = true;
		}
	}
}
