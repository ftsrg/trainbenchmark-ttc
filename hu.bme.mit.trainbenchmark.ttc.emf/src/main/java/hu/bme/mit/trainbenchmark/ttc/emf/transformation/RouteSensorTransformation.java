package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match.EMFRouteSensorMatch;

import java.util.Collection;

public class RouteSensorTransformation extends EMFTransformationAction<EMFRouteSensorMatch> {

	@Override
	public void transform(final Collection<EMFRouteSensorMatch> matches, final long nElementsToModify) {
		for (final EMFRouteSensorMatch match : matches) {
			match.getSensor().getElements().clear();
		}		
	}
	
}
