package nz.co.redium.loggenerator

import java.io.File
import java.nio.charset.Charset
import java.time.*
import kotlin.random.*

class Generator {

  companion object {
    val CUSTOMERS = listOf(
      "Max",
      "Max",
      "Max",
      "Max",
      "Max",
      "Paul",
      "Paul",
      "Paul",
      "Paul",
      "Peter",
      "Peter",
      "Peter",
      "Peter",
      "Peter",
      "Peter",
      "Phil",
      "Phil",
      "Phil",
      "Phil",
      "Phil",
      "Andrew"
    )

    val ORDERS = listOf(
      "Kettle",
      "Phone",
      "Screen",
      "Tissues",
      "Watch",
      "Antenna",
      "Heater",
      "Tree"
    )

    val LOG_FILE = File("/tmp/orders.log")
  }

  fun generate() {
    if (!LOG_FILE.exists()) {
      LOG_FILE.createNewFile()
    }
    for (i in 1..60) {
      val logEntry =
        "${LocalDateTime.now()} Customer ${getCustomer()} made an order. {item: \"${getOrder()}\"}, {price: \"${getPrice()}\"}"
      println(logEntry)
      LOG_FILE.appendText(logEntry, Charset.forName(Charsets.UTF_8.name()))
      LOG_FILE.appendText("\n", Charset.forName(Charsets.UTF_8.name()))
      Thread.sleep((8000..9999).random().toLong())
    }
  }

  private fun getPrice(): Int {
    return (50..200).random()
  }

  private fun getCustomer(): String {
    return CUSTOMERS[(CUSTOMERS.indices).random()]
  }

  private fun getOrder(): String {
    return ORDERS[(ORDERS.indices).random()]
  }
}
