package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

public abstract class AbstractRouteSensorMatch<Route, Sensor, SwitchPosition, Switch> extends AbstractMatch {

	protected final Route route;
	protected final Sensor sensor;
	protected final SwitchPosition switchPosition;
	protected final Switch sw;

	public AbstractRouteSensorMatch(final Route route, final Sensor sensor, final SwitchPosition switchPosition, final Switch sw) {
		super();
		this.route = route;
		this.sensor = sensor;
		this.switchPosition = switchPosition;
		this.sw = sw;
	}

	public Route getRoute() {
		return route;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public SwitchPosition getSwitchPosition() {
		return switchPosition;
	}

	public Switch getSw() {
		return sw;
	}

	@Override
	public String toString() {
		return "RouteSensorMatch [route=" + route + ", sensor=" + sensor + ", switchPosition=" + switchPosition + ", sw=" + sw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((sensor == null) ? 0 : sensor.hashCode());
		result = prime * result + ((sw == null) ? 0 : sw.hashCode());
		result = prime * result + ((switchPosition == null) ? 0 : switchPosition.hashCode());
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
		final AbstractRouteSensorMatch other = (AbstractRouteSensorMatch) obj;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (sensor == null) {
			if (other.sensor != null)
				return false;
		} else if (!sensor.equals(other.sensor))
			return false;
		if (sw == null) {
			if (other.sw != null)
				return false;
		} else if (!sw.equals(other.sw))
			return false;
		if (switchPosition == null) {
			if (other.switchPosition != null)
				return false;
		} else if (!switchPosition.equals(other.switchPosition))
			return false;
		return true;
	}
	
}
