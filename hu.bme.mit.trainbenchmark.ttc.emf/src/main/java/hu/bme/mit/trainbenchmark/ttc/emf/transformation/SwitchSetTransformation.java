package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

import java.util.Collection;

public class SwitchSetTransformation extends EMFTransformationAction<SwitchPosition> {

	@Override
	public void transform(final Collection<SwitchPosition> vertices, final long nElementsToModify) {
		for (final SwitchPosition switchPosition : vertices) {
			final Switch sw = switchPosition.getSwitch();
			sw.setCurrentPosition(switchPosition.getPosition());
		}
	}

}
