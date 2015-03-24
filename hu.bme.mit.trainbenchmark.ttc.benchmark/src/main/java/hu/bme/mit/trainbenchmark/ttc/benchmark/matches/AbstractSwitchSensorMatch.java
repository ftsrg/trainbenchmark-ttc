package hu.bme.mit.trainbenchmark.ttc.benchmark.matches;

@SuppressWarnings("unchecked")
public abstract class AbstractSwitchSensorMatch<T, Switch extends T> extends AbstractMatch<T> {

	public AbstractSwitchSensorMatch(final Switch sw) {
		super();
		match = (T[]) new Object[] { sw };
	}

	public Switch getSw() {
		return (Switch) match[0];
	}
	
}
