import kpi.KPICalcul
import kpi.KPIFactory
import kpi.KPIMenu
import java.io.Reader
import java.util.*

fun main() {
    val Reader = Reader()

    val devices = readFile(Reader)
        .filter { it.commande + it.impressions + it.clics + it.cout + it.pm + it.ca > 0 } // Supprime les lignes vides (cad les lignes avec que des 0)

    val kpiToCalculators = mapOf(
        KPIMenu.CA_PAR_MOIS_PAR_ANNEE to KPICalcul(KPIFactory.getKpi(KPIMenu.CA_PAR_MOIS_PAR_ANNEE), devices),
        KPIMenu.CA_PAR_APPAREIL to KPICalcul(KPIFactory.getKpi(KPIMenu.CA_PAR_APPAREIL), devices),
        KPIMenu.PANIER_MOYEN to KPICalcul(KPIFactory.getKpi(KPIMenu.PANIER_MOYEN), devices),
        KPIMenu.COUT_PAR_CLIC to KPICalcul(KPIFactory.getKpi(KPIMenu.COUT_PAR_CLIC), devices),
        KPIMenu.TAUX_DE_CLIC to KPICalcul(KPIFactory.getKpi(KPIMenu.TAUX_DE_CLIC), devices),
        KPIMenu.ROI to KPICalcul(KPIFactory.getKpi(KPIMenu.ROI), devices),
        KPIMenu.ROI_PAR_APPAREIL_PAR_MOIS to KPICalcul(KPIFactory.getKpi(KPIMenu.ROI_PAR_APPAREIL_PAR_MOIS), devices)
    )

    displayMenu()
    readInput(kpiToCalculators)
}

fun displayMenu() { // Affichage du Menu du terminal de commande
    println("Menu KPI:")
    println("1. Le chiffre d’affaires par mois par année")
    println("2. Le chiffre d’affaires par appareil")
    println("3. Le panier moyen : Chiffre d’affaires / Commandes")
    println("4. Le coût par clic : Coût / Clics")
    println("5. Le taux de clic : (Clics /impression) * 100")
    println("6. Le ROI : CA Total / Coût ")
    println("7. Le ROI segmenté par appareil et par mois (uniquement sur 2017)")
    println("8. QUITTER")
    println()
}

fun readInput(KPIlink: Map<KPIMenu, KPICalcul>) {
    val scanner = Scanner(System.`in`)

    try {
        do {
            val number = scanner.nextInt()

            if (number != 8) {
                val type = KPIMenu.values()[number - 1]
                KPIlink[type]?.work()

                clearScreen()
                displayMenu()
            }
        } while (number != 8)

        clearScreen()
        println("Bye!")
    } catch (e: Exception) {
        readInput(KPIlink)
    }
}

fun clearScreen() {
    val os = System.getProperty("os.name")
    if (os.contains("Windows")) {
        Runtime.getRuntime().exec("cls")
    } else {
        Runtime.getRuntime().exec("clear")
    }
}