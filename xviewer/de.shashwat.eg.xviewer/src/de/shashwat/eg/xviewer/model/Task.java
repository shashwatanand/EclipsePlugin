package de.shashwat.eg.xviewer.model;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * The Class Task.
 */
public class Task implements ITask {
	
	/** The run database. */
	private final RunDatabase runDatabase;
	
	/** The task type. */
	private TaskType taskType;
	
	/** The id. */
	private final String id;
	
	/** The start time. */
	private final String startTime;
	
	/** The description. */
	private final String description;
	
	/** The category. */
	private final String category;
	
	/** The email address. */
	private final String emailAddress;
	
	/** The last run date. */
	private Date lastRunDate;
	
	/** The percent complete. */
	private int percentComplete;
	
	/** The children. */
	private final List<Task> children;
	
	/** The long value. */
	private final long longValue;

	/**
	 * Instantiates a new task.
	 *
	 * @param runDb the run db
	 * @param taskType the task type
	 * @param id the id
	 * @param startTime the start time
	 * @param description the description
	 * @param category the category
	 * @param emailAddress the email address
	 * @param percentComplete the percent complete
	 */
	public Task(RunDatabase runDb, TaskType taskType, String id, String startTime, String description, String category,
			String emailAddress, int percentComplete) {
		this(runDb, taskType, new Date(), id, startTime, description, category, emailAddress, percentComplete, 50000);
	}

	/**
	 * Instantiates a new task.
	 *
	 * @param runDb the run db
	 * @param taskType the task type
	 * @param lastRunDate the last run date
	 * @param id the id
	 * @param startTime the start time
	 * @param description the description
	 * @param category the category
	 * @param emailAddress the email address
	 * @param percentComplete the percent complete
	 * @param longValue the long value
	 */
	public Task(RunDatabase runDb, TaskType taskType, Date lastRunDate, String id, String startTime, String description,
			String category, String emailAddress, int percentComplete, long longValue) {
		this.children = new ArrayList<>();
		this.runDatabase = runDb;
		this.taskType = taskType;
		this.lastRunDate = lastRunDate;
		this.id = id;
		this.startTime = startTime;
		this.description = description;
		this.category = category;
		this.emailAddress = emailAddress;
		this.percentComplete = percentComplete;
		this.longValue = longValue;
	}

	/**
	 * Adds the child.
	 *
	 * @param task the task
	 */
	public void addChild(final Task task) {
		children.add(task);
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public Collection<Task> getChildren() {
		return children;

	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getStartTime()
	 */
	@Override
	public String getStartTime() {
		return this.startTime;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getEmailAddress()
	 */
	@Override
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getPercentComplete()
	 */
	@Override
	public int getPercentComplete() {
		return this.percentComplete;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getId()
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getTaskType()
	 */
	@Override
	public TaskType getTaskType() {
		return this.taskType;
	}

	/**
	 * Sets the task type.
	 *
	 * @param taskType the new task type
	 */
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getRunDatabase()
	 */
	@Override
	public RunDatabase getRunDatabase() {
		return this.runDatabase;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getCategory()
	 */
	@Override
	public String getCategory() {
		return this.category;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getLastRunDate()
	 */
	@Override
	public Date getLastRunDate() {
		return this.lastRunDate;
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getLastRunDateStr()
	 */
	@Override
	public String getLastRunDateStr() {
		Date date = getLastRunDate();
		if (date == null) {
			return null;
		}
		return DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a", Locale.ENGLISH)
				.format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	/* (non-Javadoc)
	 * @see de.shashwat.eg.xviewer.model.ITask#getLongValue()
	 */
	@Override
	public long getLongValue() {
		return this.longValue;
	}

	/**
	 * Sets the percent complete.
	 *
	 * @param percentComplete the new percent complete
	 */
	public void setPercentComplete(Integer percentComplete) {
		this.percentComplete = percentComplete;
	}
}
