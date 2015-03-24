package hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractSwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

public class EMFSwitchSetMatch extends AbstractSwitchSetMatch<RailwayElement, Semaphore, Route, SwitchPosition, Switch> {

	public EMFSwitchSetMatch(final Semaphore semaphore, final Route route, final SwitchPosition switchPosition, final Switch sw) {
		super(semaphore, route, switchPosition, sw);
	}

}
