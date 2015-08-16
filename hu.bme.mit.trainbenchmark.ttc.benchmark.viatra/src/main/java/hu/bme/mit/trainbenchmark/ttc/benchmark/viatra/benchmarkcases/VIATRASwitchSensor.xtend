package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.SwitchSensorQuerySpecification
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayFactory

class VIATRASwitchSensor extends VIATRABenchmarkCase {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(SwitchSensorQuerySpecification.instance).action [
			val sensor = RailwayFactory.eINSTANCE.createSensor
			sw.sensor = sensor			
		].build
	}

}