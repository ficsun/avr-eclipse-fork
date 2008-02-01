/****************************************************************************
 * 
 * AVRPluginActivator.java
 * 
 * This file is part of AVR Eclipse Plugin.
 *
 ****************************************************************************/

/* $Id: AVRPluginActivator.java 9 2007-11-25 21:51:59Z thomas $ */

package de.innot.avreclipse;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.innot.avreclipse.core.paths.SystemPathHelper;

/**
 * The activator class controls the plug-in life cycle
 */
public class AVRPluginActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.innot.avreclipse.core";

	// The shared instance
	private static AVRPluginActivator plugin;

	/**
	 * The constructor
	 */
	public AVRPluginActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		// initialize the System path cache.
		// Especially on posix platforms it may take a while to find
		// the paths. SystemPathHelper.initSystemPaths() starts a 
		// background job to do the actual initialization.
		SystemPathHelper.initSystemPaths();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static AVRPluginActivator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}