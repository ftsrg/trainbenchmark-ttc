package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayFactory;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;

import java.util.Collection;

public class SwitchSensorTransformation extends EMFTransformationAction<Switch> {

	@Override
	public void transform(final Collection<Switch> vertices, final long nElementsToModify) {
		for (final Switch sw : vertices) {
			final Sensor sensor = RailwayFactory.eINSTANCE.createSensor();
			sw.setSensor(sensor);
		}
	}

}
