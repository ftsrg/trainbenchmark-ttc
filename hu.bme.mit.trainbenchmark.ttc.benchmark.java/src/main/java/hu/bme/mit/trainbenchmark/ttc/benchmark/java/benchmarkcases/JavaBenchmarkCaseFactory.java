/*******************************************************************************
 * Copyright (c) 2010-2014, Benedek Izso, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.ttc.benchmark.java.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;

public class JavaBenchmarkCaseFactory {

	public AbstractBenchmarkCase create(final String query) {
		switch (query) {
		case QueryConstants.POSLENGTH:
			return new JavaPosLength();
		case QueryConstants.ROUTESENSOR:
			return new JavaRouteSensor();
		case QueryConstants.SWITCHSENSOR:
			return new JavaSwitchSensor();
		case QueryConstants.SEMAPHORENEIGHBOR:
			return new JavaSemaphoreNeighbor();
		case QueryConstants.SWITCHSET:
			return new JavaSwitchSet();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	
}
