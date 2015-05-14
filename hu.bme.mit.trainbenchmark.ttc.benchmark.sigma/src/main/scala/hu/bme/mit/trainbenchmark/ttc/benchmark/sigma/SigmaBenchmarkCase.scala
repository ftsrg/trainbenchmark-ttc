package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import java.util
import java.util.Comparator
import scala.collection.JavaConversions.asJavaCollection
import scala.collection.JavaConversions.asScalaIterator
import scala.collection.JavaConversions.collectionAsScalaIterable
import scala.reflect.ClassTag
import fr.unice.i3s.sigma.emf.support.EMFScalaSupport
import hu.bme.mit.trainbenchmark.ttc.benchmark.emf.EMFBenchmarkCase
import hu.bme.mit.trainbenchmark.ttc.railway.RailwayElement
import hu.bme.mit.trainbenchmark.ttc.railway.support.Railway

//      while (o1s.hasNext() && o2s.hasNext()) {
//        final RailwayElement e1 = (RailwayElement) o1s.next();
//        final RailwayElement e2 = (RailwayElement) o2s.next();
//
//        final int comparison = e1.getId() - e2.getId();
//        if (comparison != 0) {
//          return comparison;
//        }

object SigmaBenchmarkComparator extends Comparator[Object] {
  def compare(o1: AnyRef, o2: AnyRef): Int = (o1, o2) match {
    case (p1:Product, p2:Product) =>
      if (p1.productArity != p2.productArity) p1.productArity - p2.productArity
      else {
        ((p1.productIterator zip p2.productIterator) collect { case (x : RailwayElement, y : RailwayElement) => x.getId - y.getId }).sum        
      }
    case (x : RailwayElement, y : RailwayElement) => x.getId - y.getId 
    case _ => sys.error(s"Unknown types to compare o1=`$o1` o2=`$o2`")
  }
}

case class SigmaBenchmarkCase[A <: RailwayElement: ClassTag, B <: AnyRef : ClassTag](query: (A) => Option[B], repair: (B => Unit)) extends EMFBenchmarkCase with EMFScalaSupport {
  protected def check(): util.Collection[Object] = {
    val xs = container.eAllContents collect { case x: A => x } map query collect { case Some(x) => x }
    matches = asJavaCollection(xs.toIterable)
    matches
  }

  protected def modify(matches: util.Collection[AnyRef]) = {
    matches foreach {
      case x: B => repair(x)
      case _ =>
    }
  }

  protected def registerComparator() = {
    comparator = SigmaBenchmarkComparator
  }
}
