/**
 * generated by Xtext 2.18.0.M3
 */
package de.shashwat.xtext.homeauto.ruleDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.shashwat.xtext.homeauto.ruleDSL.Model#getDeclaractions <em>Declaractions</em>}</li>
 * </ul>
 *
 * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Declaractions</b></em>' containment reference list.
   * The list contents are of type {@link de.shashwat.xtext.homeauto.ruleDSL.Declaration}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaractions</em>' containment reference list.
   * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getModel_Declaractions()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getDeclaractions();

} // Model
