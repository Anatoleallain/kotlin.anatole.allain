package kpi

import Device

class CAparMoisparAnnee : KPICalcul.KPIWork{
    override fun work(devices: List<Device>) {

        val CAparannee = devices.groupBy { it.annee }
        CAparannee.forEach { annee, devices ->

            val CAparmois = devices.groupBy { it.mois }

            val headers = arrayOf("Mois", "CA")
            val count = CAparmois.size
            val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

            var index = 0
            CAparmois.forEach { mois, devicesMois ->
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
            row[1] = headers, data

            println(arrayOf(outerHeaders, outerData))
        }
    }
}