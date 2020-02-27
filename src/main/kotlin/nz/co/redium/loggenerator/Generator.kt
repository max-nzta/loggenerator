package nz.co.redium.loggenerator

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
  }

  fun generate() {
    for (i in 1..20) {
      println("${LocalDateTime.now()} Customer ${getCustomer()} made an order. {item: \"${getOrder()}\"}, {price: \"${getPrice()}\"}")
      Thread.sleep((500..999).random().toLong())
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
