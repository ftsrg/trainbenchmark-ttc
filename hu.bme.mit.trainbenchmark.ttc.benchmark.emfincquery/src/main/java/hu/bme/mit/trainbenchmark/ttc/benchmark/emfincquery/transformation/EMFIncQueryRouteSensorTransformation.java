package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.RouteSensorMatch;

import java.util.Collection;

public class EMFIncQueryRouteSensorTransformation extends EMFIncQueryTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final RouteSensorMatch rsm = (RouteSensorMatch) match;
			rsm.getRoute().getDefinedBy().add(rsm.getSensor());
		}
	}

}
