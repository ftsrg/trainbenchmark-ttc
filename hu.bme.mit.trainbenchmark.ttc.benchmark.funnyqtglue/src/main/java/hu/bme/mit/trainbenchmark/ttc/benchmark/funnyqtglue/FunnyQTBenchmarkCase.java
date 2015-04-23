package hu.bme.mit.trainbenchmark.ttc.benchmark.funnyqtglue;

import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

import clojure.lang.IFn;
import clojure.java.api.Clojure;

public class FunnyQTBenchmarkCase extends EMFBenchmarkCase {
	private final IFn rule;

	public FunnyQTBenchmarkCase(final IFn rule) {
		this.rule = rule;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected final void registerComparator() {
		if (rule == FunnyQTBenchmarkLogic.POS_LENGTH) {
			comparator = (Comparator<Object>) FunnyQTBenchmarkLogic.MAKE_MATCH_COMPARATOR
					.invoke(Clojure.read(":segment"));
		} else if (rule == FunnyQTBenchmarkLogic.SWITCH_SENSOR) {
			comparator = (Comparator<Object>) FunnyQTBenchmarkLogic.MAKE_MATCH_COMPARATOR
					.invoke(Clojure.read(":sw"));
		} else if (rule == FunnyQTBenchmarkLogic.SWITCH_SET) {
			comparator = (Comparator<Object>) FunnyQTBenchmarkLogic.MAKE_MATCH_COMPARATOR
					.invoke(Clojure.read(":semaphore"), Clojure.read(":route"),
							Clojure.read(":swp"), Clojure.read(":sw"));
		} else if (rule == FunnyQTBenchmarkLogic.ROUTE_SENSOR) {
			comparator = (Comparator<Object>) FunnyQTBenchmarkLogic.MAKE_MATCH_COMPARATOR
					.invoke(Clojure.read(":route"), Clojure.read(":sensor"),
							Clojure.read(":swp"), Clojure.read(":sw"));
		} else if (rule == FunnyQTBenchmarkLogic.SEMAPHORE_NEIGHBOR) {
			comparator = (Comparator<Object>) FunnyQTBenchmarkLogic.MAKE_MATCH_COMPARATOR
					.invoke(Clojure.read(":semaphore"),
							Clojure.read(":route1"), Clojure.read(":route2"),
							Clojure.read(":sensor1"), Clojure.read(":sensor2"),
							Clojure.read(":te1"), Clojure.read(":te2"));
		} else {
			throw new RuntimeException("Unknown rule " + rule);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected final Collection<Object> check() throws IOException {
		matches = (Collection<Object>) FunnyQTBenchmarkLogic.CALL_RULE_AS_TEST
				.invoke(rule, this.resource);
		if (matches == null) {
			matches = new LinkedList<Object>();
		}
		return matches;
	}

	@Override
	protected final void modify(Collection<Object> matches) {
		for (Object m : matches) {
			((IFn) m).invoke();
		}
	}

}
