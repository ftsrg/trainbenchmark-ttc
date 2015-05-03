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

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;

/**
 * The ATL/EMFTVM implementation of the SwitchSensor benchmark.
 * 
 * @author dennis
 */
public class SemaphoreNeighbor extends ATLBenchmarkCase {

	private static SemaphoreNeighbor instance;

	/**
	 * Returns the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static SemaphoreNeighbor getInstance() {
		if (instance == null) {
			instance = new SemaphoreNeighbor();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Loads the transformation modules.
	 */
	@Override
	protected void init() throws IOException {
		super.init();

		if (queryExecEnv == null) {
			queryExecEnv = EmftvmFactory.eINSTANCE.createExecEnv();
			queryExecEnv.registerMetaModel("RAILWAY", railway);
			queryExecEnv.loadModule(queryMr, "SemaphoreNeighbourQuery");
		}

		if (transformExecEnv == null) {
			transformExecEnv = EmftvmFactory.eINSTANCE.createExecEnv();
			transformExecEnv.registerMetaModel("RAILWAY", railway);
			transformExecEnv.loadModule(transformationMr,
					"SemaphoreNeighbourRepair");
		}
	}

}
