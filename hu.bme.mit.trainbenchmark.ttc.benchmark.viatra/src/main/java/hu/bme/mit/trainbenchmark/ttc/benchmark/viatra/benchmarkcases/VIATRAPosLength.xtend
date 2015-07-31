package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification
import java.io.IOException
import java.util.Collection
import java.util.HashSet
import org.eclipse.incquery.runtime.evm.api.Activation

class VIATRAPosLength extends VIATRABenchmarkCase<PosLengthMatch> {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(PosLengthQuerySpecification.instance).action [
			segment.length = -segment.length + 1
			println("qf")
		].build
	}
//
//	override protected getMatcher() throws IncQueryException {
//		engine.getMatcher(PosLengthQuerySpecification.instance)
//	}
//
//	override protected getResultSet() throws IncQueryException {
//		matches = new HashSet
//		ruleEngine.activations.values.forEach[
//			matches.add(it)
//		]
//		matches
//	}

	override protected modify(Collection<Object> matches) {
		matches.forEach [
			(it as Activation).fire(context)
		]
	}
	
	override protected check() throws IOException {
		matches = new HashSet
		ruleEngine.activations.values.forEach[
			matches.add(it)
		]
		matches
	}

}