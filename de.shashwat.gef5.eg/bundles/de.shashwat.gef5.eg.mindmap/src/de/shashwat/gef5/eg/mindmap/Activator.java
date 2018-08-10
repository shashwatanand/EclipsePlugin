package de.shashwat.gef5.eg.mindmap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private static Injector injector;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Activator.injector = Guice.createInjector(Modules.override(new SimpleMindMapModule())
				.with(new SimpleMindMapUiModule()));
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.injector = null;
		Activator.context = null;
	}
	
	public static Injector getInjector() {
		return injector;
	}
}
