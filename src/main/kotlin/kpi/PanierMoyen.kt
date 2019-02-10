package kpi

import Device

class PanierMoyen : KPIWork{
    override fun work(devices: List<Device>) {
        val headers = arrayOf("Panier Moyen", "Nombre de commandes")
        val count = devices.filter { it.commande > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]
        devices.filter { it.commande > 0 }.forEachIndexed { index, device ->
            val row = data[index]
            row[0] = "${device.ca / device.commande}"
            row[1] = "${device.commande}"
        }
        println(arrayOf(headers, data))
        println()
    }
}