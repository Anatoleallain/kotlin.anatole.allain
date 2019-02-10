package kpi

import Device

class KPICalcul {

    interface KPIWork {
        fun work(devices: List<Device>)
    }
}