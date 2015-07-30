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

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.EMFIncQueryBenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.matches.EMFIncQueryBenchmarkComparator;

import java.io.IOException;
import java.util.Collection;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.QueryBackendRegistry;
import org.eclipse.incquery.runtime.localsearch.matcher.integration.LocalSearchBackend;
import org.eclipse.incquery.runtime.localsearch.matcher.integration.LocalSearchBackendFactory;
import org.eclipse.incquery.runtime.matchers.backend.IQueryBackend;
import org.eclipse.incquery.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;

public abstract class EMFIncQueryBenchmarkCase<Match extends IPatternMatch> extends EMFBenchmarkCase {

	protected AdvancedIncQueryEngine engine;
	protected IncQueryMatcher<Match> matcher;
	protected EMFIncQueryBenchmarkConfig eiqbc;

	@Override
	protected void registerComparator() {
		comparator = new EMFIncQueryBenchmarkComparator();
	}

	@Override
	public void init() throws IOException {
		IncQueryLoggingUtil.getDefaultLogger().setLevel(Level.OFF);
		eiqbc = (EMFIncQueryBenchmarkConfig) bc;
	}

	@Override
	protected void destroy() throws IOException {
		super.destroy();
	}

	public Collection<Object> check() throws IOException {
		if (eiqbc.isLocalSearch()) {
			try {
				return matches = getResultSet();
			} catch (IncQueryException e) {
				throw new IOException(e);
			}
		} else {
			return matches;
		}
	}

	@Override
	public void read() throws IOException {
		super.read();

		try {
			// if(eiqbc.isLocalSearch()){
			// // When running local search, make sure the factory is registered
			//
			// // This solution cannot be used yet, as the getFactory() method
			// will throw an exception due to unknown backend
			// // IQueryBackendFactory backendFactory =
			// QueryBackendRegistry.getInstance().getFactory(LocalSearchBackend.class);
			// // if(backendFactory == null){
			// //
			// QueryBackendRegistry.getInstance().registerQueryBackendFactory(LocalSearchBackend.class,
			// new LocalSearchBackendFactory());
			// // }
			//
			// Iterable<Entry<Class<? extends IQueryBackend>,
			// IQueryBackendFactory>> factories =
			// QueryBackendRegistry.getInstance()
			// .getAllKnownFactories();
			// boolean registered = false;
			// for (Entry<Class<? extends IQueryBackend>, IQueryBackendFactory>
			// entry : factories) {
			// if (entry.getKey().equals(LocalSearchBackend.class)) {
			// registered = true;
			// }
			// }
			// if (!registered) {
			// QueryBackendRegistry.getInstance().registerQueryBackendFactory(LocalSearchBackend.class,
			// new LocalSearchBackendFactory());
			// }
			//
			// }

			final EMFScope emfScope = new EMFScope(resource);
			engine = AdvancedIncQueryEngine.from(IncQueryEngine.on(emfScope));

			matches = getResultSet();
			if (!eiqbc.isLocalSearch()) {
				engine.addMatchUpdateListener(getMatcher(), new IMatchUpdateListener<Match>() {
					@Override
					public void notifyAppearance(final Match match) {
						matches.add(match);
					}

					@Override
					public void notifyDisappearance(final Match match) {
						matches.remove(match);
					}
				}, false);
			}
		} catch (final IncQueryException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract Collection<Object> getResultSet() throws IncQueryException;

	protected abstract IncQueryMatcher<Match> getMatcher() throws IncQueryException;

}
