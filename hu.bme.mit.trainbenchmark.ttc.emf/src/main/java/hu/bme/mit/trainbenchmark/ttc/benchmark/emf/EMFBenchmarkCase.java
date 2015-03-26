package hu.bme.mit.trainbenchmark.ttc.benchmark.emf;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.emf.FileBroker;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayContainer;
import hu.bme.mit.trainbenchmark.ttc.railway.impl.RailwayPackageImpl;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public abstract class EMFBenchmarkCase extends AbstractBenchmarkCase {

	protected RailwayContainer container;
	protected Resource resource;
	
	@Override
	protected void registerComparator() {
	}
	
	@Override
	public void read() throws IOException {
		RailwayPackageImpl.init();

		final String modelPath = bc.getInstanceModelPath() + "/railway-" + bc.getSize() + ".railway";
		final URI resourceURI = FileBroker.getEMFUri(modelPath);
		final ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceURI, true);

		if (resource.getContents().size() > 0 && resource.getContents().get(0) instanceof RailwayContainer) {
			container = (RailwayContainer) resource.getContents().get(0);
		}
	}

}
