/*******************************************************************************
 * Copyright (c) 2010-2015, Gabor Szarnyas, Benedek Izso, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Benedek Izso - initial API and implementation
 *   Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatcher;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation.EMFIncQueryPosLengthTransformation;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.localsearch.matcher.integration.LocalSearchBackend;
import org.eclipse.incquery.runtime.matchers.backend.QueryEvaluationHint;

import com.google.common.collect.Maps;

public class EMFIncQueryPosLength extends EMFIncQueryBenchmarkCase<PosLengthMatch> {

	@Override
	protected Collection<Object> getResultSet() throws IncQueryException {
		final Collection<Object> matches = new HashSet<>();
		for (final PosLengthMatch match : getMatcher().getAllMatches()) {
			matches.add(match);
		}
		return matches;
	}

	@Override
	protected PosLengthMatcher getMatcher() throws IncQueryException {
		if (eiqbc.isLocalSearch()) {
			return engine.getMatcher(PosLengthQuerySpecification.instance(), new QueryEvaluationHint(LocalSearchBackend.class, Maps.newHashMap()));
		} else {
			return engine.getMatcher(PosLengthQuerySpecification.instance());
		}
	}

	@Override
	protected void modify(final Collection<Object> matches) {
		final EMFIncQueryPosLengthTransformation transformation = new EMFIncQueryPosLengthTransformation();
		transformation.transform(matches);
	}

}
