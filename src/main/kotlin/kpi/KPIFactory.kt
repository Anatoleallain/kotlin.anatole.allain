package kpi

object KPIFactory {
    fun getKpi(kpiMenu: KPIMenu): KPIWork = when(kpiMenu) {
        KPIMenu.CA_PAR_MOIS_PAR_ANNEE -> CAparMoisparAnnee()
        KPIMenu.CA_PAR_APPAREIL -> CAparAppareil()
        KPIMenu.PANIER_MOYEN -> PanierMoyen()
        KPIMenu.COUT_PAR_CLIC -> CoutparClic()
        KPIMenu.TAUX_DE_CLIC -> TauxdeClic()
        KPIMenu.ROI -> ROI()
        KPIMenu.ROI_PAR_APPAREIL_PAR_MOIS -> ROIparAppareilparMois()


    }
}