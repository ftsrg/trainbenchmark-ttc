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

package hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.transformations.TransformationUtil;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.BenchmarkResult;
import hu.bme.mit.trainbenchmark.ttc.benchmark.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractBenchmarkCase<T extends AbstractMatch> {

	protected BenchmarkResult bmr;
	protected BenchmarkConfig bc;
	protected Collection<T> results;

	// simple getters and setters
	public BenchmarkResult getBenchmarkResult() {
		return bmr;
	}

	// shorthands
	public String getName() {
		return bc.getQuery();
	}

	public Collection<T> getResults() {
		return results;
	}

	// these should be implemented for each tool

	protected void init() throws IOException {
	}

	protected void destroy() throws IOException {
	}

	protected abstract void read() throws IOException;

	protected abstract Collection<T> check() throws IOException;

	protected abstract void modify(Collection<T> matches, long nElementsToModify);

	protected long getMemoryUsage() throws IOException {
		Util.runGC();
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	public void benchmarkInit(final BenchmarkConfig bc) throws IOException {
		this.bc = bc;

		bmr = new BenchmarkResult(bc.getTool(), bc.getQuery());
		bmr.setBenchmarkConfig(bc);
		init();
		runGC();
	}

	public void benchmarkDestroy() throws IOException {
		destroy();
	}

	public void benchmarkRead() throws IOException {
		bmr.restartClock();
		read();
		bmr.setReadTime();

		bmr.setReadMemory(getMemoryUsage());
}

	public void benchmarkCheck() throws IOException {
		bmr.restartClock();
		check();
		bmr.addResultSize(results.size());
		bmr.addCheckTime();

		bmr.addCheckMemory(getMemoryUsage());
	}

	public void benchmarkModify() throws IOException {
		final long nElementsToModify = Util.calcModify(bmr);
		bmr.addModifiedElementsSize(nElementsToModify);

		// we do not measure this in the benchmark results
		final List<T> candidatesList = new ArrayList<>(results);
		Collections.sort(candidatesList);
		final List<T> elementsToModify = TransformationUtil.pickRandom(nElementsToModify, candidatesList);
		
		// we measure the transformation
		bmr.restartClock();
		modify(elementsToModify, nElementsToModify);
		bmr.addTransformationTime();

		bmr.addTransformationMemory(getMemoryUsage());
	}
	
	protected void runGC() throws IOException {
		Util.runGC();
	}

}
