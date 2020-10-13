/**
 * generated by Xtext 2.18.0.M3
 */
package de.shashwat.xtext.homeauto.ruleDSL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getDescription <em>Description</em>}</li>
 *   <li>{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getWhen <em>When</em>}</li>
 *   <li>{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getThen <em>Then</em>}</li>
 * </ul>
 *
 * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Declaration
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getRule_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>When</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>When</em>' reference.
   * @see #setWhen(State)
   * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getRule_When()
   * @model
   * @generated
   */
  State getWhen();

  /**
   * Sets the value of the '{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getWhen <em>When</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When</em>' reference.
   * @see #getWhen()
   * @generated
   */
  void setWhen(State value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' reference.
   * @see #setThen(State)
   * @see de.shashwat.xtext.homeauto.ruleDSL.RuleDSLPackage#getRule_Then()
   * @model
   * @generated
   */
  State getThen();

  /**
   * Sets the value of the '{@link de.shashwat.xtext.homeauto.ruleDSL.Rule#getThen <em>Then</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' reference.
   * @see #getThen()
   * @generated
   */
  void setThen(State value);

} // Rule