package hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.emf.runtime.modelmanipulation.IModelManipulations
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationRuleFactory
import org.eclipse.viatra.emf.runtime.rules.batch.BatchTransformationStatements
import org.eclipse.viatra.emf.runtime.transformation.batch.BatchTransformation
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage
import org.eclipse.viatra.emf.runtime.modelmanipulation.SimpleModelManipulations
import hu.bme.mit.trainbenchmark.ttc.railway.impl.RailwayPackageImpl
import hu.bme.mit.trainbenchmark.ttc.emf.FileBroker
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import hu.bme.mit.trainbenchmark.ttc.benchmark.emfincquery.util.PosLengthQuerySpecification
import org.eclipse.incquery.runtime.evm.api.resolver.ConflictResolver

class MyTransformation {
	/* Transformation-related extension API */
	extension BatchTransformationRuleFactory ruleFactory = new BatchTransformationRuleFactory
	extension BatchTransformation transformation
	extension BatchTransformationStatements statements
	extension IModelManipulations manipulation

	/* Makes available the Literals of the EPackage for the manipulation API */
	extension RailwayPackage railwayPackage = RailwayPackage.eINSTANCE

	Resource resource

	new(Resource resource) {
		this.resource = resource

		/* Extensions are initialized as normal fields in Xtend */
		transformation = new BatchTransformation(resource.resourceSet)
		statements = new BatchTransformationStatements(transformation)
		manipulation = new SimpleModelManipulations(transformation.iqEngine)

//		transformation.ruleEngine.conflictResolver = new MyConflictResolver
	}

	def static void main(String[] args) {
		RailwayPackageImpl.init()

		val modelPath = "/home/szarnyasg/git/trainbenchmark-ttc/models/railway-1.railway"
		val resourceURI = FileBroker.getEMFUri(modelPath);
		val resourceSet = new ResourceSetImpl();
		val resource = resourceSet.getResource(resourceURI, true);

		val trf = new MyTransformation(resource)
		trf.trf;

//		if (resource.getContents().size() > 0 && resource.getContents().get(0) instanceof RailwayContainer) {
//			container = (RailwayContainer) resource.getContents().get(0);
//		}
	}

	val rule1 = createRule.precondition(PosLengthQuerySpecification.instance).action [
		println(it)
		segment.set(segment_Length, -segment.length)
	// vagy
//		segment.length = -segment.length + 1
	].build

	def trf() {
		rule1.fireAllCurrent
	}

}

class MyConflictResolver {
}