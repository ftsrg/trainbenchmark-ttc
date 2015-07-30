package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.PosLengthMatch
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification
import java.util.Collection
import java.util.HashSet
import org.eclipse.incquery.runtime.exception.IncQueryException

class VIATRAPosLength extends VIATRABenchmarkCase<PosLengthMatch> {

	new() {
		super()
		rule = ruleFactory.createRule.precondition(PosLengthQuerySpecification.instance).action [
			println(it)
		].build
	}

	override protected getMatcher() throws IncQueryException {
		engine.getMatcher(PosLengthQuerySpecification.instance)
	}

	override protected getResultSet() throws IncQueryException {
		val matches = new HashSet
		return matches;
	}

	override protected modify(Collection<Object> matches) {
		println("modify")
	}

}