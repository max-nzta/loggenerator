package nz.co.redium.loggenerator

import kotlinx.coroutines.*

fun main() {
  for (i in 1..10) {
    GlobalScope.launch {
      Generator().generate()
    }
  }
  Thread.sleep(20000)
}
