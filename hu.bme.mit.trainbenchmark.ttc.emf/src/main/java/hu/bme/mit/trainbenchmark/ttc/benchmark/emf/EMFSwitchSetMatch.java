package hu.bme.mit.trainbenchmark.ttc.benchmark.emf;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractMatch;
import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractSwitchSetMatch;
import hu.bme.mit.trainbenchmark.ttc.railway.Route;
import hu.bme.mit.trainbenchmark.ttc.railway.Semaphore;
import hu.bme.mit.trainbenchmark.ttc.railway.Switch;
import hu.bme.mit.trainbenchmark.ttc.railway.SwitchPosition;

public class EMFSwitchSetMatch extends AbstractSwitchSetMatch<Semaphore, Route, SwitchPosition, Switch> {

	public EMFSwitchSetMatch(final Semaphore semaphore, final Route route, final SwitchPosition switchPosition, final Switch sw) {
		super(semaphore, route, switchPosition, sw);
	}

	@Override
	public int compareTo(final AbstractMatch m1) {
		if (m1 instanceof EMFPosLengthMatch) {
			return Integer.compare(switchPosition.getId(), ((EMFSwitchSetMatch) m1).getSwitchPosition().getId());
		} else {
			return -1;
		}
	}

}
