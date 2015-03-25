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

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaSemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation.JavaSemaphoreNeighborTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class SemaphoreNeighbor extends JavaBenchmarkCase<JavaSemaphoreNeighborMatch> {

	@Override
	protected Collection<Object> check() {
		matches = new ArrayList<>();

		final TreeIterator<EObject> contents = container.eAllContents();
		while (contents.hasNext()) {
			final EObject eObject = contents.next();

			if (eObject instanceof Route) {
				final Route route1 = (Route) eObject;
				checkValid(route1);
			}
		}

		return matches;
	}

	private boolean checkValid(final Route route1) {
		final Semaphore semaphore = route1.getExit();
		for (final Sensor sensor1 : route1.getDefinedBy()) {
			for (final TrackElement te1 : sensor1.getElements()) {
				for (final TrackElement te2 : te1.getConnectsTo()) {
					final Sensor sensor2 = te2.getSensor();
					boolean goodSensor = false;

					Route matchedRoute3 = null;
					final TreeIterator<EObject> contents2 = container.eAllContents();
					while (contents2.hasNext()) {
						final EObject eObject = contents2.next();

						if (eObject instanceof Route) {
							final Route route3 = (Route) eObject;
							if ((route3.getDefinedBy().contains(sensor2)) && (route3 != route1)) {
								goodSensor = true;
								matchedRoute3 = route3; 
								break;
							}
						}
					}
					if (goodSensor) {
						final TreeIterator<EObject> contents3 = container.eAllContents();
						while (contents3.hasNext()) {
							final EObject eObject = contents3.next();

							if (eObject instanceof Route) {
								final Route route2 = (Route) eObject;
								if ((route2.getDefinedBy().contains(sensor2)) && (route2.getEntry() != null)
										&& (route2.getEntry().equals(semaphore))) {
									return true;
								}
							}
						}
						if (semaphore != null) {
							matches.add(new JavaSemaphoreNeighborMatch(semaphore, route1, matchedRoute3, sensor1, sensor2, te1, te2));
							return false;
						}
					}

				}
			}
		}

		return true;
	}

	@Override
	protected void modify(final Collection<Object> matches, final long nElementsToModify) {
		final JavaSemaphoreNeighborTransformation transformation = new JavaSemaphoreNeighborTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
