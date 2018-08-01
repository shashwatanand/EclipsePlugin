package de.shashwat.eg.xviewer.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.core.runtime.Platform;
import org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData;
import org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations;
import org.eclipse.nebula.widgets.xviewer.util.XViewerException;
import org.eclipse.osgi.service.datalocation.Location;

import de.shashwat.eg.xviewer.Activator;
import de.shashwat.eg.xviewer.utils.FileUtil;
import de.shashwat.eg.xviewer.utils.MatchFilter;
import de.shashwat.eg.xviewer.utils.UIUtil;
import de.shashwat.eg.xviewer.utils.XViewerLogger;

/**
 * The Class CustomXViewerCustomizations.
 */
public class CustomXViewerCustomizations extends XViewerCustomizations {
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#deleteCustomization(org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData)
	 */
	@Override
	public void deleteCustomization(CustomizeData custData) throws Exception {
		File file = new File(getFilename(custData));
		if (file.exists()) {
			boolean success = file.delete();
			if (!success) {
				throw new XViewerException("Delete Customization Failed");
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#isCustomizationPersistAvailable()
	 */
	@Override
	public boolean isCustomizationPersistAvailable() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#getUserDefaultCustData()
	 */
	@Override
	public CustomizeData getUserDefaultCustData() throws XViewerException {
		File file = new File(getDefaultFilename());
		if (!file.exists()) {
			return null;
		}

		String defaultGuid = FileUtil.readFile(file).replaceAll("\\s", "");
		if (defaultGuid != null) {
			for (CustomizeData custData : getSavedCustDatas()) {
				if (custData.getGuid().equals(defaultGuid)) {
					return custData;
				}
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#getSavedCustDatas()
	 */
	@Override
	public List<CustomizeData> getSavedCustDatas() throws XViewerException {
		List<CustomizeData> customDatas = new ArrayList<>();
		customDatas.add(DefaultCustomizations.getCompletionCustomization());
		customDatas.add(DefaultCustomizations.getDescriptionCustomization());
		
		Location instanceLocation = Platform.getInstanceLocation();
		//String userHome = System.getProperty("user.home");
		List<String> fileNames = UIUtil.readListFromDir(new File(instanceLocation.getURL().getPath()), new MatchFilter("XViewer_CustData_.*\\.xml"), true);
		for (String fileName : fileNames) {
			customDatas.add(new CustomizeData(FileUtil.readFile(instanceLocation.getURL().getPath() + "/" + fileName)));
		}
		return customDatas;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#isCustomizationUserDefault(org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData)
	 */
	@Override
	public boolean isCustomizationUserDefault(CustomizeData custData) throws XViewerException {
		File file = new File(getDefaultFilename());
		if (!file.exists()) {
			return false;
		}
		String defaultGuid = FileUtil.readFile(getDefaultFilename()).replaceAll("\\s", "");
		return custData.getGuid().equals(defaultGuid);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#saveCustomization(org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData)
	 */
	@Override
	public void saveCustomization(CustomizeData custData) throws Exception {
		UIUtil.writeStringToFile(custData.getXml(true), new File(getFilename(custData)));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.nebula.widgets.xviewer.customize.XViewerCustomizations#setUserDefaultCustData(org.eclipse.nebula.widgets.xviewer.core.model.CustomizeData, boolean)
	 */
	@Override
	public void setUserDefaultCustData(CustomizeData newCustData, boolean set) throws XViewerException {
		if (set) {
			try {
				UIUtil.writeStringToFile(newCustData.getGuid(), new File(getDefaultFilename()));
			} catch (IOException e) {
				XViewerLogger.logAndPopup(Activator.class, Level.SEVERE, e);
			}
		} else {
			File file = new File(getDefaultFilename());
			if (file.exists()) {
				boolean success = file.delete();
				if (!success) {
					throw new XViewerException("Delete Customization Failed");
				}
			}
		}
	}

	/**
	 * Gets the filename.
	 *
	 * @param custData the cust data
	 * @return the filename
	 */
	private String getFilename(CustomizeData custData) {
		Location instanceLocation = Platform.getInstanceLocation();
		//String userHome = System.getProperty("user.home");
		return instanceLocation.getURL().getPath() + "/" + "XViewer_CustData_" + custData.getGuid() + ".xml";
	}

	/**
	 * Gets the default filename.
	 *
	 * @return the default filename
	 */
	private String getDefaultFilename() {
		Location instanceLocation = Platform.getInstanceLocation();
		//String userHome = System.getProperty("user.home");
		return instanceLocation.getURL().getPath() + "/" + "XViewer_CustDataUserDefault.txt";
	}
}
