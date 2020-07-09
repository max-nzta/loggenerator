package nz.co.redium.loggenerator

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    while (true) {
        GlobalScope.launch {
            Generator().generate()
        }
        Thread.sleep(600000)
    }
}
