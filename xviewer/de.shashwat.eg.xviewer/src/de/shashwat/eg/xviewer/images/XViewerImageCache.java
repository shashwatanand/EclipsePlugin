package de.shashwat.eg.xviewer.images;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class XViewerImageCache {
	static Map<String, Image> imageCache = new HashMap<String, Image>();
	   static Map<String, ImageDescriptor> imageDescriptorCache = new HashMap<String, ImageDescriptor>();

	   public static Image getImage(String imageName) {
	      if (!imageCache.containsKey(imageName)) {
	         imageCache.put(imageName, getImageDescriptor(imageName).createImage());
	      }
	      return imageCache.get(imageName);
	   }

	   public static ImageDescriptor getImageDescriptor(String imageName) {
	      if (!imageDescriptorCache.containsKey(imageName)) {
	         URL url = XViewerImageCache.class.getResource(imageName);
	         imageDescriptorCache.put(imageName, ImageDescriptor.createFromURL(url));
	      }
	      return imageDescriptorCache.get(imageName);
	   }
}
