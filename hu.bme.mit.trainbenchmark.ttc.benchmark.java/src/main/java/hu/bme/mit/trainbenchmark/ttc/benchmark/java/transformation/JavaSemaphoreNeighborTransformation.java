package hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaSemaphoreNeighborMatch;

import java.util.Collection;

public class JavaSemaphoreNeighborTransformation extends JavaTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final JavaSemaphoreNeighborMatch snm = (JavaSemaphoreNeighborMatch) match;
			snm.getRoute2().setEntry(snm.getSemaphore());
		}
	}

}
