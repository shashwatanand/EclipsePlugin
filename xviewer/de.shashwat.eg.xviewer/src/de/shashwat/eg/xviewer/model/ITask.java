package de.shashwat.eg.xviewer.model;

import java.util.Date;

/**
 * The Interface ITask.
 */
public interface ITask {
	
	/**
	 * The Enum RunDatabase.
	 */
	public enum RunDatabase {
		
		/** The Production database. */
		Production_Database, 
 /** The Test database. */
 Test_Database
	};

	/**
	 * The Enum TaskType.
	 */
	public enum TaskType {
		
		/** The Regression. */
		Regression, 
 /** The Database health. */
 Database_Health, 
 /** The Data exchange. */
 Data_Exchange, 
 /** The Backup. */
 Backup, 
 /** The Refreshed. */
 Refreshed
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public String getStartTime();

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress();

	/**
	 * Gets the percent complete.
	 *
	 * @return the percent complete
	 */
	public int getPercentComplete();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId();

	/**
	 * Gets the task type.
	 *
	 * @return the task type
	 */
	public TaskType getTaskType();

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription();

	/**
	 * Gets the run database.
	 *
	 * @return the run database
	 */
	public RunDatabase getRunDatabase();

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory();

	/**
	 * Gets the last run date.
	 *
	 * @return the last run date
	 */
	public Date getLastRunDate();

	/**
	 * Gets the last run date str.
	 *
	 * @return the last run date str
	 */
	public String getLastRunDateStr();

	/**
	 * Gets the long value.
	 *
	 * @return the long value
	 */
	public long getLongValue();

}
