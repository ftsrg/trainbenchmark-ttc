package hu.bme.mit.trainbenchmark.ttc.benchmark.java.matches;

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

public class JavaSwitchSetMatch extends JavaMatch {

	public JavaSwitchSetMatch(final Semaphore semaphore, final Route route, final SwitchPosition switchPosition, final Switch sw) {
		super();
		match = new RailwayElement[] { semaphore, route, switchPosition, sw };
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
