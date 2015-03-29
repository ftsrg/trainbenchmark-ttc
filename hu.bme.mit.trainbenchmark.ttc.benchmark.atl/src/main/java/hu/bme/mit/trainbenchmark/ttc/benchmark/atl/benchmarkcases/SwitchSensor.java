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

import java.io.IOException;

/**
 * The ATL/EMFTVM implementation of the SwitchSensor benchmark.
 * 
 * @author dennis
 */
public class SwitchSensor extends ATLBenchmarkCase {

	/**
	 * {@inheritDoc}
	 * 
	 * Loads the transformation modules.
	 */
	@Override
	protected void init() throws IOException {
		super.init();

		queryExecEnv.loadModule(queryMr, "SwitchSensor");
		transformExecEnv.loadModule(transformationMr, "SwitchSensorRepair");
	}

}
