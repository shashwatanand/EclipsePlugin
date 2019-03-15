package de.shashwat.reply.challenges.model;

public class CustomerH {
	private int x;
	private int y;
	private int rewardPoints;
	/**
	 * @param x
	 * @param y
	 * @param rewardPoints
	 */
	public CustomerH(int x, int y, int rewardPoints) {
		super();
		this.x = x;
		this.y = y;
		this.rewardPoints = rewardPoints;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the rewardPoints
	 */
	public int getRewardPoints() {
		return rewardPoints;
	}
	/**
	 * @param rewardPoints the rewardPoints to set
	 */
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
}
