package kpi

import Device

class ROIparAppareilparMois : KPIWork{
    override fun work(devices: List<Device>) {
        val headers = arrayOf("Appareil", "ROI")
        val count = devices.groupBy { it.device }.filterValues { it.sumBy { it.cout } > 0 }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

        var index = 0
        devices.groupBy { it.device }.forEach { device, items ->
            if (items.sumBy { it.cout } > 0) {
                val row = data[index]
                row[0] = "$device"
                row[1] = "${items.sumBy { it.ca } / items.sumBy { it.cout }}"
                index++
            }
        }

        println(arrayOf(headers, data))
        println()

        val headers2 = arrayOf("Mois", "ROI")
        val count2 = devices.groupBy { it.mois }.filterValues { it.sumBy { it.cout } > 0 }.count()
        val data2 = Array(size = count2) { Array(size = 2) { "" } } // String[count2][2]

        index = 0
        devices.groupBy { it.mois }.forEach { mois, items ->
            if (items.sumBy { it.cout } > 0) {
                val row = data2[index]
                row[0] = "$mois"
                row[1] = "${items.sumBy { it.ca } / items.sumBy { it.cout }}"
                index++
            }
        }

        println(arrayOf(headers2, data2))
        println()
    }
}