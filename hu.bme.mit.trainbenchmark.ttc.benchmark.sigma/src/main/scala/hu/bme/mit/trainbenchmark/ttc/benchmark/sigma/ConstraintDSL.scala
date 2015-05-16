package hu.bme.mit.trainbenchmark.ttc.benchmark.sigma

import org.eclipse.emf.ecore.EObject

import scala.collection.JavaConversions._
import scala.reflect.ClassTag

case class BooleanConstraint[A <: EObject : ClassTag](query: (A) => Boolean, repair: (A) => Unit)

case class Constraint[A <: EObject : ClassTag, B <: AnyRef : ClassTag](query: (A) => Iterable[B], repair: (B) => Unit)

abstract class Validator[A <: EObject : ClassTag, B <: AnyRef : ClassTag] {
  def check(container: EObject): Iterator[B]

  def repair(matches: Iterator[B]): Unit
}

case class ConstraintValidator[A <: EObject : ClassTag, B <: AnyRef : ClassTag](constraint: Constraint[A, B]) extends Validator[A, B] {
  override def repair(matches: Iterator[B]): Unit = matches foreach constraint.repair

  override def check(container: EObject): Iterator[B] =
    container.eAllContents collect { case x: A => x } flatMap constraint.query
}

case class BooleanConstraintValidator[A <: EObject : ClassTag](constraint: BooleanConstraint[A]) extends Validator[A, A] {
  override def repair(matches: Iterator[A]): Unit = matches foreach constraint.repair

  override def check(container: EObject): Iterator[A] =
    container.eAllContents collect { case x: A if constraint.query(x) => x }
}
