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

package hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios;

import java.io.IOException;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.BenchmarkResult;

public abstract class AbstractBenchmarkLogic {

	protected BenchmarkConfig benchmarkConfig;

	public BenchmarkResult runBenchmark() throws IOException {
		final ScenarioLogic scenario = new ScenarioLogic();

		BenchmarkResult latestBR = null;
		for (int i = 1; i <= benchmarkConfig.getRuns(); i++) {
			final AbstractBenchmarkCase benchmarkCase = getBenchmarkCase(benchmarkConfig.getQuery());
			latestBR = scenario.runBenchmark(benchmarkConfig, benchmarkCase, i);
		}
		return latestBR;
	}

	protected abstract AbstractBenchmarkCase getBenchmarkCase(String query);

	public BenchmarkConfig getBenchmarkConfig() {
		return benchmarkConfig;
	}

}
