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

package hu.bme.mit.trainbenchmark.ttc.benchmark.java.benchmarkcases;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match.EMFSwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.emf.transformation.SwitchSetTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Signal;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class SwitchSet extends JavaBenchmarkCase<EMFSwitchSetMatch> {

	@Override
	protected Collection<EMFSwitchSetMatch> check() {
		matches = new ArrayList<>();

		final TreeIterator<EObject> contents = container.eAllContents();
		while (contents.hasNext()) {
			final EObject eObject = contents.next();

			if (eObject instanceof Route) {
				final Route route = (Route) eObject;
				final Semaphore semaphore = route.getEntry();
				if (semaphore == null) {
					continue;
				}
				if (semaphore.getSignal() == Signal.GO) {
					for (final SwitchPosition switchPosition : route.getFollows()) {
						final Switch sw = switchPosition.getSwitch();
						if (sw.getCurrentPosition() != switchPosition.getPosition()) {
							matches.add(new EMFSwitchSetMatch(semaphore, route, switchPosition, sw));
						}
					}
				}
			}
		}

		return matches;
	}

	@Override
	protected void modify(final Collection<EMFSwitchSetMatch> matches, final long nElementsToModify) {
		final SwitchSetTransformation transformation = new SwitchSetTransformation();
		transformation.transform(matches, nElementsToModify);
	}

}
