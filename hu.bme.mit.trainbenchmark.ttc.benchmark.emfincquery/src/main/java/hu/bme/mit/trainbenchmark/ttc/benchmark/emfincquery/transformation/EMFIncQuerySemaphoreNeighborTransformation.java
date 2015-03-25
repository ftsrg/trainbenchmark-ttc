package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SemaphoreNeighborMatch;

import java.util.Collection;

public class EMFIncQuerySemaphoreNeighborTransformation extends EMFIncQueryTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final SemaphoreNeighborMatch snm = (SemaphoreNeighborMatch) match;
			snm.getRoute1().setExit(null);
		}
	}

}
