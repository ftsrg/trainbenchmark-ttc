/*******************************************************************************
 * Copyright (c) 2015, Dennis Wagelaar
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Dennis Wagelaar
 *******************************************************************************/
package hu.bme.mit.trainbenchmark.ttc.benchmark.atl.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.m2m.atl.emftvm.util.Tuple;

/**
 * Comparator for ATL query matches.
 * 
 * @author dennis
 */
public class ATLBenchmarkComparator implements Comparator<Object> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(final Object o1, final Object o2) {
		if (o1 instanceof Tuple) {
			final Iterator<Object> o1s = ((Tuple) o1).asMap().values()
					.iterator();
			final Iterator<Object> o2s = ((Tuple) o2).asMap().values()
					.iterator();
			while (o1s.hasNext() && o2s.hasNext()) {
				final RailwayElement e1 = (RailwayElement) o1s.next();
				final RailwayElement e2 = (RailwayElement) o2s.next();

				final int comparison = e1.getId() - e2.getId();
				if (comparison != 0) {
					return comparison;
				}
			}
		} else {
			final RailwayElement e1 = (RailwayElement) o1;
			final RailwayElement e2 = (RailwayElement) o2;
			return e1.getId() - e2.getId();
		}
		return 0;
	}

}
