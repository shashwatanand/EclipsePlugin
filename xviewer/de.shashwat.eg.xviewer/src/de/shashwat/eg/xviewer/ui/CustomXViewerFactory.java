package de.shashwat.eg.xviewer.ui;

import org.eclipse.nebula.widgets.xviewer.XViewerFactory;

public class CustomXViewerFactory extends XViewerFactory {

	public CustomXViewerFactory() {
		super("Shashwat.XViewer");
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

}
