package kpi

import Device

class ROI : KPIWork{
    override fun work(devices: List<Device>) {
        println("ROI=${devices.sumBy { it.ca } / devices.sumBy { it.cout }}")
    }
}