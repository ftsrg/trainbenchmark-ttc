package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.benchmarkcases

import hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.incquery.runtime.api.IPatternMatch
import org.eclipse.viatra.emf.runtime.modelmanipulation.IModelManipulations
import org.eclipse.viatra.emf.runtime.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationStatements
import org.eclipse.viatra.emf.runtime.transformation.batch.BatchTransformation
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationRule
import java.io.IOException

abstract class VIATRABenchmarkCase<Match extends IPatternMatch> extends EMFIncQueryBenchmarkCase<Match> {

	protected var BatchTransformationRule rule

	// Transformation-related extension API
	protected extension BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory
	protected extension BatchTransformation transformation
	protected extension BatchTransformationStatements statements
	protected extension IModelManipulations manipulation

	// Makes available the Literals of the EPackage for the manipulation API
	extension RailwayPackage railwayPackage = RailwayPackage.eINSTANCE

	override read() throws IOException {
		super.read
		/* Extensions are initialized as normal fields in Xtend */
		transformation = new BatchTransformation(resource.resourceSet)
		statements = new BatchTransformationStatements(transformation)
		manipulation = new SimpleModelManipulations(transformation.iqEngine)
		rule.fireAllCurrent
	}

}