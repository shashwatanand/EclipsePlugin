 
package de.shashwat.gef5.eg.mindmap.part;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.eclipse.gef.common.adapt.AdapterKey;
import org.eclipse.gef.mvc.fx.domain.HistoricizingDomain;
import org.eclipse.gef.mvc.fx.domain.IDomain;
import org.eclipse.gef.mvc.fx.viewer.IViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Guice;

import de.shashwat.gef5.eg.mindmap.Activator;
import de.shashwat.gef5.eg.mindmap.SimpleMindMapModule;


public class MindMapPart {
	private HistoricizingDomain domain;

	@Inject
	public MindMapPart() {
		Activator.getInjector().injectMembers(this);
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		SimpleMindMapModule module = new SimpleMindMapModule();
		this.domain = (HistoricizingDomain) Guice.createInjector(module).getInstance(IDomain.class);

		// create viewers
		hookViewers();

		// activate domain
		domain.activate();

		// load contents
		populateViewerContents();
	}

	private void populateViewerContents() {
		// TODO Auto-generated method stub
		
	}

	private void hookViewers() {
		// TODO Auto-generated method stub
		
	}
	
	public IViewer getContentViewer() {
		return domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
	}
}