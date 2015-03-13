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

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.BenchmarkResult;

import java.io.IOException;

public abstract class AbstractBenchmarkLogic {

	protected BenchmarkConfig benchmarkConfig;

	public BenchmarkResult runBenchmark() throws IOException {
		final AbstractBenchmarkCase<?> benchmarkCase = getBenchmarkCase(benchmarkConfig.getQuery());

		final Scenario scenario = new Scenario();
		final BenchmarkResult bmr = scenario.runBenchmark(benchmarkConfig, benchmarkCase);
		return bmr;
	}

	protected abstract AbstractBenchmarkCase<?> getBenchmarkCase(String query);
	
//	protected AbstractBenchmarkCase<?> getTestCase(final ClassLoader classLoader) {
//		try {
//			final String queryClassName = "hu.bme.mit.trainbenchmark.ttc.benchmark." + getTool().toLowerCase() + ".benchmarkcases."
//					+ benchmarkConfig.getQuery();
//			final Class<?> queryClass = classLoader.loadClass(queryClassName);
//			return (AbstractBenchmarkCase<?>) queryClass.newInstance();
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			throw new UnsupportedOperationException(e);
//		}
//	}

	public BenchmarkConfig getBenchmarkConfig() {
		return benchmarkConfig;
	}

	protected abstract String getTool();
}
