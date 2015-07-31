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
package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;

public class VIATRABenchmarkCaseFactory {

	public AbstractBenchmarkCase create(final String query) {
		switch (query) {
		case QueryConstants.POSLENGTH:
			return new VIATRAPosLength();
		// case QueryConstants.ROUTESENSOR:
		// return new VIATRARouteSensor();
		// case QueryConstants.SWITCHSENSOR:
		// return new VIATRASwitchSensor();
		// case QueryConstants.SEMAPHORENEIGHBOR:
		// return new VIATRASemaphoreNeighbor();
		// case QueryConstants.SWITCHSET:
		// return new VIATRASwitchSet();
		default:
			throw new IllegalArgumentException();
		}
	}

}
