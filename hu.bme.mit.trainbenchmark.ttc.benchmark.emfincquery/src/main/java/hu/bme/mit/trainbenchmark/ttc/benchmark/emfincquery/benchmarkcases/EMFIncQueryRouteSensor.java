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

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatcher;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation.EMFIncQueryRouteSensorTransformation;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;

public class EMFIncQueryRouteSensor extends EMFIncQueryBenchmarkCase<RouteSensorMatch> {

	@Override
	protected Collection<Object> getResultSet() throws IncQueryException {
		final Collection<Object> matches = new HashSet<>();
		for (final RouteSensorMatch match : RouteSensorMatcher.on(engine).getAllMatches()) {
			matches.add(match);
		}
		return matches;
	}

	@Override
	protected IncQueryMatcher<RouteSensorMatch> getMatcher() throws IncQueryException {
		return RouteSensorMatcher.on(engine);
	}

	@Override
	protected void modify(final Collection<Object> matches, final long nElementsToModify) {
		final EMFIncQueryRouteSensorTransformation transformation = new EMFIncQueryRouteSensorTransformation();
		transformation.transform(matches, nElementsToModify);
	}

}
