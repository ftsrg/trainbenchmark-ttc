package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.SwitchSetQuerySpecification

class VIATRASwitchSet extends VIATRABenchmarkCase {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(SwitchSetQuerySpecification.instance).action [
			sw.currentPosition = swP.position
		].build
	}

}