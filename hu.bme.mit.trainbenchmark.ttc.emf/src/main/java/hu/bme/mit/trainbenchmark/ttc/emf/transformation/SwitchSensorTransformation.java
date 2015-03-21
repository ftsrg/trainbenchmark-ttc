package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFSwitchSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayFactory;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;

import java.util.Collection;

public class SwitchSensorTransformation extends EMFTransformationAction<EMFSwitchSensorMatch> {

	@Override
	public void transform(final Collection<EMFSwitchSensorMatch> matches, final long nElementsToModify) {
		for (final EMFSwitchSensorMatch match : matches) {
			final Sensor sensor = RailwayFactory.eINSTANCE.createSensor();
			match.getSw().setSensor(sensor);
		}
	}

}
