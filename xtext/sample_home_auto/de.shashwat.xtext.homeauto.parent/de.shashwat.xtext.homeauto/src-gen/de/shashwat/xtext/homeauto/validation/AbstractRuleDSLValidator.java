/*
 * generated by Xtext 2.18.0.M3
 */
package de.shashwat.xtext.homeauto.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractRuleDSLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage.eINSTANCE);
		return result;
	}
}
