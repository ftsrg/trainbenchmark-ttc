package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.TrackElement;

public class JavaSemaphoreNeighborMatch extends JavaMatch {

	public JavaSemaphoreNeighborMatch(final Semaphore semaphore, final Route route1, final Route route3, final Sensor sensor1,
			final Sensor sensor2, final TrackElement te1, final TrackElement te2) {
		super();
		match = new RailwayElement[] { semaphore, route1, route3, sensor1, sensor2, te1, te2 };
	}

	public Semaphore getSemaphore() {
		return (Semaphore) match[0];
	}

	public Route getRoute1() {
		return (Route) match[1];
	}

	public Route getRoute3() {
		return (Route) match[2];
	}

	public Sensor getSensor1() {
		return (Sensor) match[3];
	}

	public Sensor getSensor2() {
		return (Sensor) match[4];
	}

	public TrackElement getTe1() {
		return (TrackElement) match[5];
	}

	public TrackElement getTe2() {
		return (TrackElement) match[6];
	}
	
}
