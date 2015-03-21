package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFPosLengthMatch;

import java.util.Collection;

public class PosLengthTransformation extends EMFTransformationAction<EMFPosLengthMatch> {

	@Override
	public void transform(final Collection<EMFPosLengthMatch> matches, final long nElementsToModify) {
		System.out.println("tr");
		for (final EMFPosLengthMatch match : matches) {
			final int length = match.getSegment().getLength();
			match.getSegment().setLength(-length + 1);
		}
	}

}
