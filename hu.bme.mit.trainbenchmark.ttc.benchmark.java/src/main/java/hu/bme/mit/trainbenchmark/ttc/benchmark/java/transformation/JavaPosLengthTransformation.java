package hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaPosLengthMatch;

import java.util.Collection;

public class JavaPosLengthTransformation extends JavaTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final JavaPosLengthMatch plm = (JavaPosLengthMatch) match;
			final int length = plm.getSegment().getLength();
			plm.getSegment().setLength(-length + 1);
		}
	}

}
