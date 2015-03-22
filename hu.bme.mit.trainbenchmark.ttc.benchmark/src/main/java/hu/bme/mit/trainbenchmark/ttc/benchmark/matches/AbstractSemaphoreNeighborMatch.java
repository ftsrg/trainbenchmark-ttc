package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

public abstract class AbstractSemaphoreNeighborMatch<Semaphore, Route, Sensor, TrackElement> extends AbstractMatch {

	protected Semaphore semaphore;
	protected Route route1;
	protected Route route3;
	protected Sensor sensor1;
	protected Sensor sensor2;
	protected TrackElement te1;
	protected TrackElement te2;

	public AbstractSemaphoreNeighborMatch(final Semaphore semaphore, final Route route1, final Route route3, final Sensor sensor1,
			final Sensor sensor2, final TrackElement te1, final TrackElement te2) {
		super();
		this.semaphore = semaphore;
		this.route1 = route1;
		this.route3 = route3;
		this.sensor1 = sensor1;
		this.sensor2 = sensor2;
		this.te1 = te1;
		this.te2 = te2;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public Route getRoute1() {
		return route1;
	}

	public Route getRoute3() {
		return route3;
	}

	public Sensor getSensor1() {
		return sensor1;
	}

	public Sensor getSensor2() {
		return sensor2;
	}

	public TrackElement getTe1() {
		return te1;
	}

	public TrackElement getTe2() {
		return te2;
	}

	@Override
	public String toString() {
		return "SemaphoreNeighborMatch [semaphore=" + semaphore + ", route1=" + route1 + ", route3=" + route3 + ", sensor1=" + sensor1
				+ ", sensor2=" + sensor2 + ", te1=" + te1 + ", te2=" + te2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((route1 == null) ? 0 : route1.hashCode());
		result = prime * result + ((route3 == null) ? 0 : route3.hashCode());
		result = prime * result + ((semaphore == null) ? 0 : semaphore.hashCode());
		result = prime * result + ((sensor1 == null) ? 0 : sensor1.hashCode());
		result = prime * result + ((sensor2 == null) ? 0 : sensor2.hashCode());
		result = prime * result + ((te1 == null) ? 0 : te1.hashCode());
		result = prime * result + ((te2 == null) ? 0 : te2.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AbstractSemaphoreNeighborMatch other = (AbstractSemaphoreNeighborMatch) obj;
		if (route1 == null) {
			if (other.route1 != null)
				return false;
		} else if (!route1.equals(other.route1))
			return false;
		if (route3 == null) {
			if (other.route3 != null)
				return false;
		} else if (!route3.equals(other.route3))
			return false;
		if (semaphore == null) {
			if (other.semaphore != null)
				return false;
		} else if (!semaphore.equals(other.semaphore))
			return false;
		if (sensor1 == null) {
			if (other.sensor1 != null)
				return false;
		} else if (!sensor1.equals(other.sensor1))
			return false;
		if (sensor2 == null) {
			if (other.sensor2 != null)
				return false;
		} else if (!sensor2.equals(other.sensor2))
			return false;
		if (te1 == null) {
			if (other.te1 != null)
				return false;
		} else if (!te1.equals(other.te1))
			return false;
		if (te2 == null) {
			if (other.te2 != null)
				return false;
		} else if (!te2.equals(other.te2))
			return false;
		return true;
	}
	
}
