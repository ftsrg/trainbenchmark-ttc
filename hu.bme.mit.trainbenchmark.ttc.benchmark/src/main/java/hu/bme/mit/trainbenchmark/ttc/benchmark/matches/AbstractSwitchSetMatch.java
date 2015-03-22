package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

@SuppressWarnings("unchecked")
public abstract class AbstractSwitchSetMatch<T, Semaphore extends T, Route extends T, SwitchPosition extends T, Switch extends T> extends AbstractMatch<T> {

	public AbstractSwitchSetMatch(final Semaphore semaphore, final Route route, final SwitchPosition switchPosition, final Switch sw) {
		super();
		match = (T[]) new Object[] { semaphore, route, switchPosition, sw };
	}

	public Semaphore getSemaphore() {
		return (Semaphore) match[0];
	}

	public Route getRoute() {
		return (Route) match[1];
	}

	public SwitchPosition getSwitchPosition() {
		return (SwitchPosition) match[2];
	}

	public Switch getSw() {
		return (Switch) match[3];
	}
	
}
