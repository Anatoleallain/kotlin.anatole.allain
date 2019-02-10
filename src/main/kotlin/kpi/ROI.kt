package kpi

import Device

class ROI : KPICalcul.KPIWork{
    override fun work(devices: List<Device>) {
        println("ROI=${devices.sumBy { it.ca } / devices.sumBy { it.cout }}")
        println()
        println()
    }
}