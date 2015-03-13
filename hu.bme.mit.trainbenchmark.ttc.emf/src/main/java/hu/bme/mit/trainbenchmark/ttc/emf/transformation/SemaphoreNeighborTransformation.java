package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.Route;

import java.util.Collection;

public class SemaphoreNeighborTransformation extends EMFTransformationAction<Route> {

	@Override
	public void transform(final Collection<Route> vertices, final long nElementsToModify) {
		for (final Route route : vertices) {
			route.setExit(null);
		}
	}

}
