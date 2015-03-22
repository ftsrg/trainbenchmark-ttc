package hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractPosLengthMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

public class EMFPosLengthMatch extends AbstractPosLengthMatch<Segment> {

	public EMFPosLengthMatch(final Segment segment) {
		super(segment);
	}

	@Override
	public int compareTo(final AbstractMatch m1) {
		if (m1 instanceof EMFPosLengthMatch) {
			return Integer.compare(segment.getId(), ((EMFPosLengthMatch) m1).getSegment().getId());
		} else {
			return -1;
		}
	}

}
