package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;

public class JavaSwitchSensorMatch extends JavaMatch {

	public JavaSwitchSensorMatch(final Switch sw) {
		super();
		match = new RailwayElement[] { sw };
	}

	public Switch getSw() {
		return (Switch) match[0];
	}
	
}
