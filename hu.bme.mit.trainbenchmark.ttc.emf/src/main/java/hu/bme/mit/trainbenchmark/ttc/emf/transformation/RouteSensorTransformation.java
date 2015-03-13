package hu.bme.mit.trainbenchmark.ttc.emf.transformation;

import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;

import java.util.Collection;

public class RouteSensorTransformation extends EMFTransformationAction<Sensor> {

	@Override
	public void transform(final Collection<Sensor> vertices, final long nElementsToModify) {
		for (final Sensor sensor : vertices) {
			sensor.getElements().clear();
		}		
	}
	
}
