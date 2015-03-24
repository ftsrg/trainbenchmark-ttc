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
package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases.EMFIncQueryBenchmarkCaseFactory;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;

import org.apache.commons.cli.ParseException;

public class EMFIncQueryBenchmarkLogic extends AbstractBenchmarkLogic {

	public EMFIncQueryBenchmarkLogic(final String[] args) throws ParseException {
		super();
		benchmarkConfig = new BenchmarkConfig(args, getTool());
	}

	public EMFIncQueryBenchmarkLogic(final BenchmarkConfig bc) {
		super();
		this.benchmarkConfig = bc;
	}
	
	@Override
	protected String getTool() {
		return "EMFIncQuery";
	}

	@Override
	protected AbstractBenchmarkCase<?, ?> getBenchmarkCase(final String query) {
		final EMFIncQueryBenchmarkCaseFactory factory = new EMFIncQueryBenchmarkCaseFactory();
		return factory.create(query);
	}

}
