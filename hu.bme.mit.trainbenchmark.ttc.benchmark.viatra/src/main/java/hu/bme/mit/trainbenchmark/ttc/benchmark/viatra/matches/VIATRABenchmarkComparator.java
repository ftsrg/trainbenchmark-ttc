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
package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.matches;

import java.util.Comparator;

import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;

public class VIATRABenchmarkComparator implements Comparator<Object> {

	@Override
	public int compare(final Object o1, final Object o2) {
		final Object[] m1 = ((BasePatternMatch) o1).toArray();
		final Object[] m2 = ((BasePatternMatch) o2).toArray();
		for (int i = 0; i < m1.length; i++) {
			final RailwayElement t1 = (RailwayElement) m1[i];
			final RailwayElement t2 = (RailwayElement) m2[i];

			final int comparison = t1.getId() - t2.getId();
			if (comparison != 0) {
				return comparison;
			}
		}

		return 0;
	}

}
