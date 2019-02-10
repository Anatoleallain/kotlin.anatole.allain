package kpi

import Device

class CAparMoisparAnnee : KPIWork{
    override fun work(devices: List<Device>) {

        val caparannee = devices.groupBy { it.annee }
        caparannee.forEach { annee, devices ->

            val caparmois = devices.groupBy { it.mois }

            val headers = arrayOf("Mois", "CA")
            val count = caparmois.size
            val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

            var index = 0
            caparmois.forEach { mois, devicesMois ->
                val row = data[index]
                row[0] = "$mois"
                row[1] = "${devicesMois.sumBy { it.ca }}"
                index++
            }

            val outerHeaders = arrayOf("Annees", "CA par mois")
            val size = devices.groupBy { it.annee }.size
            val outerData = Array(size = size) { Array(size = 2) { "" } } // String[size][2]

            val row = outerData[0]
            row[0] = "$annee"
            row[1] = "$headers $data"

            println(arrayOf(outerHeaders, outerData))
        }
    }
}