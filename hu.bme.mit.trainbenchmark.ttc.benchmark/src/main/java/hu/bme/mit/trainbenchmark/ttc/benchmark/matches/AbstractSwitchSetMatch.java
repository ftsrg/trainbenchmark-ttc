package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

public abstract class AbstractSwitchSetMatch<Semaphore, Route, SwitchPosition, Switch> extends AbstractMatch {

	protected Semaphore semaphore;
	protected Route route;
	protected SwitchPosition switchPosition;
	protected Switch sw;

	public AbstractSwitchSetMatch(final Semaphore semaphore, final Route route, final SwitchPosition switchPosition, final Switch sw) {
		super();
		this.semaphore = semaphore;
		this.route = route;
		this.switchPosition = switchPosition;
		this.sw = sw;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public Route getRoute() {
		return route;
	}

	public SwitchPosition getSwitchPosition() {
		return switchPosition;
	}

	public Switch getSw() {
		return sw;
	}

	@Override
	public String toString() {
		return "SwitchSetMatch [semaphore=" + semaphore + ", route=" + route + ", switchPosition=" + switchPosition + ", sw=" + sw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((semaphore == null) ? 0 : semaphore.hashCode());
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
		final AbstractSwitchSetMatch other = (AbstractSwitchSetMatch) obj;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (semaphore == null) {
			if (other.semaphore != null)
				return false;
		} else if (!semaphore.equals(other.semaphore))
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
