package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.SwitchSetMatch;

import java.util.Collection;

public class EMFIncQuerySwitchSetTransformation extends EMFIncQueryTransformationAction {

	@Override
	public void transform(final Collection<Object> matches, final long nElementsToModify) {
		for (final Object match : matches) {
			final SwitchSetMatch ssm = (SwitchSetMatch) match;
			ssm.getSw().setCurrentPosition(ssm.getSwitchPosition().getPosition());
		}
	}

}
