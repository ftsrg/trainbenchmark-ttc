package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.SemaphoreNeighborQuerySpecification

class VIATRASemaphoreNeighbor extends VIATRABenchmarkCase {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(SemaphoreNeighborQuerySpecification.instance).action [
			route2.entry = semaphore
		].build
	}

}