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
