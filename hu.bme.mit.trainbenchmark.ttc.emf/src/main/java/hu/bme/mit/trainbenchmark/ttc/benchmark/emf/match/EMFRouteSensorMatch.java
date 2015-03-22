package hu.bme.mit.trainbenchmark.ttc.benchmark.emf.match;

import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.matches.AbstractRouteSensorMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Sensor;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

public class EMFRouteSensorMatch extends AbstractRouteSensorMatch<Route, Sensor, SwitchPosition, Switch> {

	public EMFRouteSensorMatch(final Route route, final Sensor sensor, final SwitchPosition switchPosition, final Switch sw) {
		super(route, sensor, switchPosition, sw);
	}

	@Override
	public int compareTo(final AbstractMatch m1) {
		if (m1 instanceof EMFRouteSensorMatch) {
			return Integer.compare(sensor.getId(), ((EMFRouteSensorMatch) m1).getSensor().getId());
		} else {
			return -1;
		}
	}

}
