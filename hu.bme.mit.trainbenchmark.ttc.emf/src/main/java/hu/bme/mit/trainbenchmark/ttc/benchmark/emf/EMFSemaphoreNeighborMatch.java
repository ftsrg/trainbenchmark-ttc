package hu.bme.mit.trainbenchmark.ttc.benchmark.emf;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractSemaphoreNeighborMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

public class EMFSemaphoreNeighborMatch extends AbstractSemaphoreNeighborMatch<Semaphore, Route, Sensor, TrackElement> {

	public EMFSemaphoreNeighborMatch(final Semaphore semaphore, final Route route1, final Route route3, final Sensor sensor1, final Sensor sensor2, final TrackElement te1,
			final TrackElement te2) {
		super(semaphore, route1, route3, sensor1, sensor2, te1, te2);
	}

	@Override
	public int compareTo(final AbstractMatch m1) {
		if (m1 instanceof EMFRouteSensorMatch) {
			return Integer.compare(route1.getId(), ((EMFSemaphoreNeighborMatch) m1).getRoute1().getId());
		} else {
			return -1;
		}
	}

}
