/*******************************************************************************
 * Copyright (c) 2010-2015, Gabor Szarnyas, Benedek Izso, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
/**
 */
package hu.bme.mit.trainbenchmark.ttc.railway;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement#getId2 <em>Id2</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage#getRailwayElement()
 * @model abstract="true"
 * @generated
 */
public interface RailwayElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id2</em>' attribute.
	 * @see #setId2(int)
	 * @see hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage#getRailwayElement_Id2()
	 * @model
	 * @generated
	 */
	int getId2();

	/**
	 * Sets the value of the '{@link hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement#getId2 <em>Id2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id2</em>' attribute.
	 * @see #getId2()
	 * @generated
	 */
	void setId2(int value);

} // RailwayElement
