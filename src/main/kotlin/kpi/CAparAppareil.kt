package kpi

import Device

class CAparAppareil : KPIWork{
    override fun work(devices: List<Device>) {
        val headers = arrayOf("Appareil", "CA")
        val count = devices.groupBy { it.device }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

        var index = 0
        val CAparAppareil = devices.groupBy { it.device }
        CAparAppareil.forEach { device, items ->
            val row = data[index]
            row[0] = "$device"
            row[1] = "${items.sumBy { it.ca }}"
            index++
        }
        println(arrayOf(headers, data))
        println()
    }
}