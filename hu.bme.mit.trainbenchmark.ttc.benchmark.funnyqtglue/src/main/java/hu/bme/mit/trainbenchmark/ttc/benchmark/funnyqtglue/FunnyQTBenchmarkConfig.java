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

package hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue;

import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.ChangeSet;

import org.apache.commons.cli.ParseException;

public class FunnyQTBenchmarkConfig extends BenchmarkConfig {

	public FunnyQTBenchmarkConfig(final String[] args) throws ParseException {
		super(args);
	}

	public FunnyQTBenchmarkConfig(final int size, final int runs, final String query, final int iterationCount, final ChangeSet changeSet,
			final long transformationConstant) {
		super(size, runs, query, iterationCount, changeSet, transformationConstant);
	}

	@Override
	public String getTool() {
		return "ATL";
	}

}
