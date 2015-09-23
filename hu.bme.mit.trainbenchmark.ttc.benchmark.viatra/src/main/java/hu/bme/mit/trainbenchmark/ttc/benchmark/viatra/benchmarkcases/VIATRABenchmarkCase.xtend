package hu.bme.mit.trainbenchmark.ttc.benchmark.viatra.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.matches.EMFIncQueryMatchComparator
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage
import java.io.IOException
import java.util.Collection
import java.util.HashSet
import org.apache.log4j.Level
import org.eclipse.incquery.runtime.emf.EMFScope
import org.eclipse.incquery.runtime.evm.api.Activation
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil
import org.eclipse.viatra.emf.runtime.modelmanipulation.IModelManipulations
import org.eclipse.viatra.emf.runtime.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationRule
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationStatements
import org.eclipse.viatra.emf.runtime.transformation.batch.BatchTransformation

abstract class VIATRABenchmarkCase extends EMFBenchmarkCase {

	protected var BatchTransformationRule rule

	// Transformation-related extension API
	protected extension BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory
	protected extension BatchTransformation transformation
	protected extension BatchTransformationStatements statements
	protected extension IModelManipulations manipulation
	protected extension RailwayPackage railwayPackage = RailwayPackage.eINSTANCE

	override read() throws IOException {
		super.read

		val emfScope = new EMFScope(resource);

		// extensions are initialized as normal fields in Xtend
		transformation = new BatchTransformation(resource.resourceSet)
		statements = new BatchTransformationStatements(transformation)
		manipulation = new SimpleModelManipulations(transformation.iqEngine)
		statements.registerRule(rule.ruleSpecification)
	}

	override protected registerComparator() {
		comparator = new EMFIncQueryMatchComparator
	}

	override protected init() throws IOException {
		IncQueryLoggingUtil.getDefaultLogger.setLevel(Level.OFF);
	}

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