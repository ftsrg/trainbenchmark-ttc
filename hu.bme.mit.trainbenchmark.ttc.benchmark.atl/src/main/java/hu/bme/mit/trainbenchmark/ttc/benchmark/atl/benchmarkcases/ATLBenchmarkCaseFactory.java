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
 *   Dennis Wagelaar
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.ttc.benchmark.atl.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;

public class ATLBenchmarkCaseFactory {

	public AbstractBenchmarkCase create(final String query) {
		final ATLBenchmarkCase benchmarkCase;
		switch (query) {
		case QueryConstants.POSLENGTH:
			benchmarkCase = PosLength.getInstance();
			break;
		case QueryConstants.ROUTESENSOR:
			benchmarkCase = RouteSensor.getInstance();
			break;
		case QueryConstants.SWITCHSENSOR:
			benchmarkCase = SwitchSensor.getInstance();
			break;
		case QueryConstants.SEMAPHORENEIGHBOR:
			benchmarkCase = SemaphoreNeighbor.getInstance();
			break;
		case QueryConstants.SWITCHSET:
			benchmarkCase = SwitchSet.getInstance();
			break;
		default:
			throw new IllegalArgumentException();
		}
		benchmarkCase.reset();
		return benchmarkCase;
	}

}
