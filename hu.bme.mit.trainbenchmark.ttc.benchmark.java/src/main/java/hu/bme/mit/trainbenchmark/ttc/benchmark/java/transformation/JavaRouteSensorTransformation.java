package hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaRouteSensorMatch;

import java.util.Collection;

public class JavaRouteSensorTransformation extends JavaTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final JavaRouteSensorMatch rsm = (JavaRouteSensorMatch) match;
			rsm.getRoute().getDefinedBy().add(rsm.getSensor());
		}
	}

}
