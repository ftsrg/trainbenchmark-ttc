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
package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;

public class EMFIncQueryBenchmarkCaseFactory {

	public AbstractBenchmarkCase create(final String query) {
		switch (query) {
		case QueryConstants.POSLENGTH:
			return new PosLength();
		case QueryConstants.ROUTESENSOR:
			return new RouteSensor();
		case QueryConstants.SWITCHSENSOR:
			return new SwitchSensor();
		case QueryConstants.SEMAPHORENEIGHBOR:
			return new SemaphoreNeighbor();
		case QueryConstants.SWITCHSET:
			return new SwitchSet();
		default:
			throw new IllegalArgumentException();
		}
	}
	
	
}
