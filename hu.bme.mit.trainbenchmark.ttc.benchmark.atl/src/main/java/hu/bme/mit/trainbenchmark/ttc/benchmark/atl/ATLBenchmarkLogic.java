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

package hu.bme.mit.trainbenchmark.ttc.benchmark.atl;

import hu.bme.mit.trainbenchmark.ttc.benchmark.atl.benchmarkcases.ATLBenchmarkCaseFactory;
import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;

import org.apache.commons.cli.ParseException;

public class ATLBenchmarkLogic extends AbstractBenchmarkLogic {

	public ATLBenchmarkLogic(final String[] args) throws ParseException {
		super();
		benchmarkConfig = new BenchmarkConfig(args, getTool());
	}

	public ATLBenchmarkLogic(final BenchmarkConfig bc) {
		super();
		this.benchmarkConfig = bc;
	}

	@Override
	protected String getTool() {
		return "ATL";
	}

	@Override
	protected AbstractBenchmarkCase getBenchmarkCase(final String query) {
		final ATLBenchmarkCaseFactory factory = new ATLBenchmarkCaseFactory();
		return factory.create(query);
	}
	
}
