package kpi

import Device

class CoutparClic : KPIWork{
    override fun work(devices: List<Device>) {
        val headers = arrayOf("Coût par clic", "Nombre de clics")
        val count = devices.filter { it.clics > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]
        devices.filter { it.clics > 0 }.forEachIndexed { index, device ->
            val row = data[index]
            row[0] = "${device.cout / device.clics}"
            row[1] = "${device.clics}"
        }
        println(arrayOf(headers, data))
        println()
    }
}