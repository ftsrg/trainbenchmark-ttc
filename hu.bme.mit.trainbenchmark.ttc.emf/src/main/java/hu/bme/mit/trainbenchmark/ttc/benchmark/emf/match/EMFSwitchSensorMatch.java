package hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractSwitchSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;

public class EMFSwitchSensorMatch extends AbstractSwitchSensorMatch<RailwayElement, Switch> {

	public EMFSwitchSensorMatch(final Switch sw) {
		super(sw);
	}

}
