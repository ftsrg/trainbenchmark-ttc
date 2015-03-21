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
package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

public abstract class EMFIncQueryBenchmarkCase<TBM extends AbstractMatch, Match extends IPatternMatch> extends EMFBenchmarkCase<TBM> {

	protected AdvancedIncQueryEngine engine;
	protected IncQueryMatcher<Match> matcher;

	@Override
	public void init() throws IOException {
		IncQueryLoggingUtil.getDefaultLogger().setLevel(Level.OFF);
	}

	@Override
	public Collection<TBM> check() {
		return results;
	}

	@Override
	public void read() throws IOException {
		super.read();
		
		try {
			final EMFScope emfScope = new EMFScope(resource);
			engine = AdvancedIncQueryEngine.createUnmanagedEngine(emfScope);

			results = getResultSet();
			engine.addMatchUpdateListener(getMatcher(), new IMatchUpdateListener<Match>() {
				@Override
				public void notifyAppearance(final Match match) {
					results.add(convertMatch(match));
				}

				@Override
				public void notifyDisappearance(final Match match) {
					results.remove(convertMatch(match));
				}
			}, false);
		} catch (final IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract Set<TBM> getResultSet() throws IncQueryException;

	protected abstract IncQueryMatcher<Match> getMatcher() throws IncQueryException;

	protected abstract TBM convertMatch(Match match);

}
