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
package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

public class JavaPosLengthMatch extends JavaMatch {

	public JavaPosLengthMatch(final Segment segment) {
		super();
		match = new RailwayElement[] { segment };
	}

	public Segment getSegment() {
		return (Segment) match[0];
	}

}
