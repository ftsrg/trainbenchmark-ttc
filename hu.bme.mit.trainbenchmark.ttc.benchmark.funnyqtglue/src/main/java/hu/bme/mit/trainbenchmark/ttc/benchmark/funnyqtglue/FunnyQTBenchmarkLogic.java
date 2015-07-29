package hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue;

import hu.bme.mit.trainbenchmark.ttc.benchmark.benchmarkcases.AbstractBenchmarkCase;
import hu.bme.mit.trainbenchmark.ttc.benchmark.config.BenchmarkConfig;
import hu.bme.mit.trainbenchmark.ttc.benchmark.scenarios.AbstractBenchmarkLogic;
import hu.bme.mit.trainbenchmark.ttc.constants.QueryConstants;
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayPackage;

import org.apache.commons.cli.ParseException;
import org.eclipse.emf.ecore.EPackage;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class FunnyQTBenchmarkLogic extends AbstractBenchmarkLogic {

	private final static String SOLUTION_NS = "ttc15-train-benchmark-funnyqt.core";

	static {
		EPackage.Registry.INSTANCE.put(RailwayPackage.eNS_URI,
				RailwayPackage.eINSTANCE);
		Clojure.var("clojure.core", "require")
				.invoke(Clojure.read(SOLUTION_NS));
	}

	final static IFn POS_LENGTH = Clojure.var(SOLUTION_NS, "pos-length");
	final static IFn ROUTE_SENSOR = Clojure.var(SOLUTION_NS, "route-sensor");
	final static IFn SEMAPHORE_NEIGHBOR = Clojure.var(SOLUTION_NS,
			"semaphore-neighbor");
	final static IFn SWITCH_SENSOR = Clojure.var(SOLUTION_NS, "switch-sensor");
	final static IFn SWITCH_SET = Clojure.var(SOLUTION_NS, "switch-set");
	final static IFn CALL_RULE_AS_TEST = Clojure.var(SOLUTION_NS,
			"call-rule-as-test");

	final static IFn MAKE_MATCH_COMPARATOR = Clojure.var(SOLUTION_NS,
			"make-match-comparator");

	public FunnyQTBenchmarkLogic(final String[] args) throws ParseException {
		super();
		benchmarkConfig = new BenchmarkConfig(args, getTool());
	}

	public FunnyQTBenchmarkLogic(final BenchmarkConfig bc) {
		super();
		this.benchmarkConfig = bc;
	}

	@Override
	protected String getTool() {
		return "FunnyQT";
	}

	@Override
	protected AbstractBenchmarkCase getBenchmarkCase(final String query) {
		switch (query) {
		case QueryConstants.POSLENGTH:
			return new FunnyQTBenchmarkCase(POS_LENGTH);
		case QueryConstants.ROUTESENSOR:
			return new FunnyQTBenchmarkCase(ROUTE_SENSOR);
		case QueryConstants.SWITCHSENSOR:
			return new FunnyQTBenchmarkCase(SWITCH_SENSOR);
		case QueryConstants.SEMAPHORENEIGHBOR:
			return new FunnyQTBenchmarkCase(SEMAPHORE_NEIGHBOR);
		case QueryConstants.SWITCHSET:
			return new FunnyQTBenchmarkCase(SWITCH_SET);
		default:
			throw new IllegalArgumentException();
		}
	}

}
