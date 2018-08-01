package de.shashwat.eg.xviewer.ui;

import org.eclipse.nebula.widgets.xviewer.IXViewerFactory;
import org.eclipse.nebula.widgets.xviewer.XViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class CustomXViewer extends XViewer {

	public CustomXViewer(Tree tree) {
		this(tree, new CustomXViewerFactory());
	}

	public CustomXViewer(Tree tree, IXViewerFactory xViewerFactory) {
		super(tree, xViewerFactory);
	}

	public CustomXViewer(Shell shell, int style) {
		super(shell, style, new CustomXViewerFactory());
	}

	public CustomXViewer(Composite parent, int style) {
		super(parent, style, new CustomXViewerFactory());
	}

}
