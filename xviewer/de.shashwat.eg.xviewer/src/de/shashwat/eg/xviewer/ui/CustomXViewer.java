package de.shashwat.eg.xviewer.ui;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.nebula.widgets.xviewer.IXViewerFactory;
import org.eclipse.nebula.widgets.xviewer.XViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import de.shashwat.eg.xviewer.model.ITask;

public class CustomXViewer extends XViewer {
	private final Set<ITask> runList;

	public CustomXViewer(Tree tree) {
		this(tree, new CustomXViewerFactory());
	}

	public CustomXViewer(Tree tree, IXViewerFactory xViewerFactory) {
		super(tree, xViewerFactory);
		this.runList = new HashSet<ITask>();
	}

	public CustomXViewer(Shell shell, int style) {
		super(shell, style, new CustomXViewerFactory());
		this.runList = new HashSet<ITask>();
	}

	public CustomXViewer(Composite parent, int style) {
		super(parent, style, new CustomXViewerFactory());
		this.runList = new HashSet<ITask>();
	}

	public boolean isScheduled(ITask autoRunTask) {
		return true;
	}

	public boolean isRun(ITask autoRunTask) {
		return runList.contains(autoRunTask);
	}

}
