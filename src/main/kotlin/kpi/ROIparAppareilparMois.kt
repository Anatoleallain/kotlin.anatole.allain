package kpi

import Device

class ROIparAppareilparMois : KPIWork{
    override fun work(devices: List<Device>) {

        val roiparAppareil = devices.groupBy { it.device }
        roiparAppareil.forEach { device, devices ->

            val roiparmois = devices.groupBy { it.mois }

            val headers = arrayOf("Mois", "ROI")
            val count = roiparmois.size
            val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

            var index = 0
            roiparmois.forEach { mois, devicesMois ->
                val row = data[index]
                row[0] = "$mois"
                row[1] = "${(devicesMois.sumBy { it.ca })/(devicesMois.sumBy{it.cout}.toDouble())}"
                index++
            }

            val outerHeaders = arrayOf("Appareil", "ROI par mois")
            val size = devices.groupBy { it.device }.size
            val outerData = Array(size = size) { Array(size = 2) { "" } } // String[size][2]

            val row = outerData[0]
            row[0] = "$device"
            row[1] = "$headers $data"

            println("$outerHeaders")
            println("$outerData")
        }
    }
}