package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

public abstract class AbstractSwitchSensorMatch<Switch> extends AbstractMatch {

	protected Switch sw;
	
	public AbstractSwitchSensorMatch(final Switch sw) {
		super();
		this.sw = sw;
	}

	public Switch getSw() {
		return sw;
	}
	
	@Override
	public String toString() {
		return "SwitchSensorMatch [switch=" + sw + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sw == null) ? 0 : sw.hashCode());
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
		final AbstractSwitchSensorMatch other = (AbstractSwitchSensorMatch) obj;
		if (sw == null) {
			if (other.sw != null)
				return false;
		} else if (!sw.equals(other.sw))
			return false;
		return true;
	}	
	
}
