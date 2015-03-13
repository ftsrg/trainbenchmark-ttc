package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.Segment;

import java.util.Collection;

public class PosLengthTransformation extends EMFTransformationAction<Segment> {

	@Override
	public void transform(final Collection<Segment> vertices, final long nElementsToModify) {
		for (final Segment segment : vertices) {
			final int length = segment.getLength();
			segment.setLength(-length + 1);
		}
	}

}
