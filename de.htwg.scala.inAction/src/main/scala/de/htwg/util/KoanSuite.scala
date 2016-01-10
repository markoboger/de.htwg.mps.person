

package de.htwg.util

import org.scalatest.Reporter
import org.scalatest.FunSuite
import org.scalatest.Args
import org.scalatest.Status
import org.scalatest.FailedStatus
import org.scalatest.SucceededStatus
import org.scalatest.events.Event
import org.scalatest.events.TestSucceeded

trait KoanSuite extends FunSuite {
  override def run(testName: Option[String], args:Args):Status = {

    if (testName == null)
      throw new NullPointerException("testName was null")
    if (args.reporter == null)
      throw new NullPointerException("reporter was null")
    if (args.stopper == null)
      throw new NullPointerException("stopper was null")
    if (args.filter == null)
      throw new NullPointerException("filter was null")
    if (args.configMap == null)
      throw new NullPointerException("configMap was null")
    if (args.distributor == null)
      throw new NullPointerException("distributor was null")
    if (args.tracker == null)
      throw new NullPointerException("tracker was null")

    class KoanReporter(wrappedReporter: Reporter) extends Reporter {
      var succeeded = false

      override def apply(event: Event) = {
        event match {
          case e: TestSucceeded => succeeded = true
          case _ =>
        }
        wrappedReporter(event)
      }
    }

    val stopRequested = args.stopper

    // If a testName is passed to run, just run that, else run the tests returned
    // by testNames.
    testName match {
      case Some(tn) => runTest(tn, args)
      case None =>{
        val tests = testNames.iterator
        var failed = false
        for (test <- tests) {
            val koanReporter = new KoanReporter(args.reporter)
            runTest(test, args)
            failed = !koanReporter.succeeded
        }
          if (failed) FailedStatus else SucceededStatus
        }
    }
  }

  def koan(name: String)(fun: => Unit) = test(name.stripMargin)(fun)
}