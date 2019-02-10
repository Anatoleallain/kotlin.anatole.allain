package kpi

import Device

interface KPIWork {
    fun work(devices: List<Device>)
}