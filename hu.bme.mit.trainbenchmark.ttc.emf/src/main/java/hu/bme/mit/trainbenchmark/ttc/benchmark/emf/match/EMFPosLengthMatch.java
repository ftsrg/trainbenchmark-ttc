package hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractPosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

public class EMFPosLengthMatch extends AbstractPosLengthMatch<RailwayElement, Segment> {

	public EMFPosLengthMatch(final Segment segment) {
		super(segment);
	}

}
