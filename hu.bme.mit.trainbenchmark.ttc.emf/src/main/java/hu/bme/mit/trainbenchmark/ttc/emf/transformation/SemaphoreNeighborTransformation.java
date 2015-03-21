package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFSemaphoreNeighborMatch;

import java.util.Collection;

public class SemaphoreNeighborTransformation extends EMFTransformationAction<EMFSemaphoreNeighborMatch> {

	@Override
	public void transform(final Collection<EMFSemaphoreNeighborMatch> matches, final long nElementsToModify) {
		for (final EMFSemaphoreNeighborMatch match : matches) {
			match.getRoute1().setExit(null);
		}
	}

}
