package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

@SuppressWarnings("unchecked")
public abstract class AbstractSemaphoreNeighborMatch<T, Semaphore extends T, Route extends T, Sensor extends T, TrackElement extends T> extends AbstractMatch<T> {

	public AbstractSemaphoreNeighborMatch(final Semaphore semaphore, final Route route1, final Route route3, final Sensor sensor1,
			final Sensor sensor2, final TrackElement te1, final TrackElement te2) {
		super();
		match = (T[]) new Object[] { semaphore, route1, route3, sensor1, sensor2, te1, te2 };
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
