package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification

class VIATRAPosLength extends VIATRABenchmarkCase {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(PosLengthQuerySpecification.instance).action [
			segment.length = -segment.length + 1
		].build
	}

}