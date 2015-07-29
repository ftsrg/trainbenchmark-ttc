package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import java.util
import java.util.Comparator

import fr.unice.i3s.sigma.emf.support.EMFScalaSupport
import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement
import org.eclipse.emf.ecore.EObject

import scala.collection.JavaConversions._
import scala.language.implicitConversions
import scala.reflect.ClassTag

object SigmaBenchmarkCase {
  implicit def booleanConstraint2benchmark[A <: EObject : ClassTag](query: BooleanConstraint[A]): SigmaBenchmarkCase[A, A] = SigmaBenchmarkCase[A,A](BooleanConstraintValidator[A](query))
  implicit def constraint2benchmark[A <: EObject : ClassTag, B <: AnyRef : ClassTag](query: Constraint[A,B]): SigmaBenchmarkCase[A, B] = SigmaBenchmarkCase[A,B](ConstraintValidator[A,B](query))
}

case class SigmaBenchmarkCase[A <: EObject : ClassTag, B <: AnyRef : ClassTag](validator: Validator[A, B]) extends EMFBenchmarkCase with EMFScalaSupport {

  override protected def check(): util.Collection[AnyRef] = {
    matches = asJavaCollection(validator.check(container).toIterable)
    matches
  }

  override protected def modify(matches: util.Collection[AnyRef]) = {
    validator repair (matches collect { case x: B => x }).iterator
  }

  override protected def registerComparator() = {
    comparator = SigmaBenchmarkComparator
  }

}

object SigmaBenchmarkComparator extends Comparator[Object] {
  def compare(o1: AnyRef, o2: AnyRef): Int = (o1, o2) match {
    case (p1: Product, p2: Product) =>
      if (p1.productArity != p2.productArity) p1.productArity - p2.productArity
      else {
        ((p1.productIterator zip p2.productIterator) collect {
          case (x: RailwayElement, y: RailwayElement) => x.getId - y.getId
        }).sum
      }
    case (x: RailwayElement, y: RailwayElement) => x.getId - y.getId
    case _ => sys.error(s"Unknown types to compare o1=`$o1` o2=`$o2`")
  }
}
