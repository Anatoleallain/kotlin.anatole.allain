package kpi

import Device

class KPICalcul(private val barocwork: KPIWork, private val devices: List<Device>) {

    fun work() {
        barocwork.work(devices)
    }
}