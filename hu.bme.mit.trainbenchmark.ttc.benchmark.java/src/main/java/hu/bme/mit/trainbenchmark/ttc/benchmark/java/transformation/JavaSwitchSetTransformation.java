package hu.bme.mit.trainbenchmark.ttc.benchmark.java.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches.JavaSwitchSetMatch;

import java.util.Collection;

public class JavaSwitchSetTransformation extends JavaTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final JavaSwitchSetMatch ssm = (JavaSwitchSetMatch) match;
			ssm.getSw().setCurrentPosition(ssm.getSwitchPosition().getPosition());
		}
	}

}
