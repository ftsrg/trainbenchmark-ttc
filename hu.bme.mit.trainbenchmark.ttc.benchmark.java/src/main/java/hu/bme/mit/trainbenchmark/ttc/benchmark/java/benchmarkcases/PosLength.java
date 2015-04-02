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

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaPosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation.JavaPosLengthTransformation;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class PosLength extends JavaBenchmarkCase<JavaPosLengthMatch> {

	@Override
	protected Collection<Object> check() {
		matches = new ArrayList<>();
		
		final TreeIterator<EObject> contents = container.eAllContents();	
		while (contents.hasNext()) {
			final EObject eObject = contents.next();
		
			// (Segment)
			if (eObject instanceof Segment) {
				final Segment segment = (Segment) eObject;
				// Segment.length <= 0
				if (segment.getLength() <= 0) {
					matches.add(new JavaPosLengthMatch(segment));
				}
			}
		}
		
		return matches;
	}

	@Override
	protected void modify(final Collection<Object> matches, final long nElementsToModify) {
		final JavaPosLengthTransformation transformation = new JavaPosLengthTransformation();
		transformation.transform(matches, nElementsToModify);
	}
	
}
