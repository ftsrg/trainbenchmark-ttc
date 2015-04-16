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

package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.emf.RailwayElementComparator;

import java.util.Comparator;

import com.google.common.collect.ComparisonChain;

public class JavaRouteSensorMatchComparator implements Comparator<Object> {

	protected final static RailwayElementComparator rec = new RailwayElementComparator();

	@Override
	public int compare(final Object o1, final Object o2) {
		final JavaRouteSensorMatch j1 = (JavaRouteSensorMatch) o1;
		final JavaRouteSensorMatch j2 = (JavaRouteSensorMatch) o2;

		return ComparisonChain.start().//
				compare(j1.getRoute(), j2.getRoute(), rec).//
				compare(j1.getSensor(), j2.getSensor(), rec).//
				compare(j1.getSwitchPosition(), j2.getSwitchPosition(), rec).//
				compare(j1.getSw(), j2.getSw(), rec).result();
	}

}
