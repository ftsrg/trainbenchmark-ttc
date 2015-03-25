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

public class ScenarioLogic {

	public BenchmarkResult runBenchmark(final BenchmarkConfig bc, final AbstractBenchmarkCase testCase) throws IOException {
		testCase.benchmarkInit(bc);

		testCase.benchmarkRead();
		testCase.benchmarkCheck();
		for (int i = 0; i < bc.getIterationCount(); i++) {
			testCase.benchmarkModify();
			testCase.benchmarkCheck();
		}
		testCase.benchmarkDestroy();

		final BenchmarkResult bmr = testCase.getBenchmarkResult();
		System.out.print(bmr);
		return bmr;
	}

}
