package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFSwitchSetMatch;

import java.util.Collection;

public class SwitchSetTransformation extends EMFTransformationAction<EMFSwitchSetMatch> {

	@Override
	public void transform(final Collection<EMFSwitchSetMatch> matches, final long nElementsToModify) {
		for (final EMFSwitchSetMatch match : matches) {
			match.getSw().setCurrentPosition(match.getSwitchPosition().getPosition());
		}
	}

}
