package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.RouteSensorQuerySpecification

class VIATRARouteSensor extends VIATRABenchmarkCase {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(RouteSensorQuerySpecification.instance).action [
			route.definedBy.add(sensor)
		].build
	}

}