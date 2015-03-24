package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

@SuppressWarnings("unchecked")
public abstract class AbstractRouteSensorMatch<T, Route extends T, Sensor extends T, SwitchPosition extends T, Switch extends T> extends AbstractMatch<T> {

	public AbstractRouteSensorMatch(final Route route, final Sensor sensor, final SwitchPosition switchPosition, final Switch sw) {
		super();
		match = (T[]) new Object[] { route, sensor, switchPosition, sw };
	}
	
	public Route getRoute() {
		return (Route) match[0];
	}
	
	public Sensor getSensor() {
		return (Sensor) match[1];
	}

	public SwitchPosition getSwitchPosition() {
		return (SwitchPosition) match[2];
	}

	public Switch getSw() {
		return (Switch) match[3];
	}
	
}
