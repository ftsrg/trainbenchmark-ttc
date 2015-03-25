package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch;

import java.util.Collection;

public class EMFIncQueryPosLengthTransformation extends EMFIncQueryTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final PosLengthMatch plm = (PosLengthMatch) match;
			final int length = plm.getSegment().getLength();
			plm.getSegment().setLength(-length + 1);
		}
	}

}
