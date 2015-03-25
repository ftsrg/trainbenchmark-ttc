package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

public class JavaRouteSensorMatch extends JavaMatch {

	public JavaRouteSensorMatch(final Route route, final Sensor sensor, final SwitchPosition switchPosition, final Switch sw) {
		super();
		match = new RailwayElement[] { route, sensor, switchPosition, sw };
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
