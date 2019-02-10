class Device(
    var annee: Int,
    var device: String?,
    var commande: Int,
    var impressions: Int,
    var clics: Int,
    var cout: Int,
    var pm: Int,
    var ca: Int,
    var mois: String?
) {


    override fun toString(): String {
        return "Appareil [annee=$annee, device=$device, commande=$commande, impressions=$impressions, clics=$clics, cout=$cout, pm=$pm, ca=$ca, mois=$mois]"
    }
}