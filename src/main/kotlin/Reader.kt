import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.util.*
import trie.Categories

class Reader {
    fun readFile(filename: String = "data_csv.csv"): List<Device> {
        var fileReader: BufferedReader? = null

        try {
            val devices = ArrayList<Device>()
            var line: String?


            val classLoader = javaClass.classLoader
            val file = File(classLoader.getResource(filename)!!.file)

            fileReader = BufferedReader(FileReader(file))

            // Read CSV header
            fileReader.readLine()

            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(";")
                if (tokens.size > 0) {
                    val device = Device(
                        Integer.parseInt(tokens[Categories.APPAREIL_ANNEE_IDX]),
                        tokens[Categories.APPAREIL_DEVICE_IDX],
                        Integer.parseInt(tokens[Categories.APPAREIL_COMMANDE_IDX]),
                        Integer.parseInt(tokens[Categories.APPAREIL_IMPRESSION_IDX]),
                        Integer.parseInt(tokens[Categories.APPAREIL_CLICS_IDX]),
                        Integer.parseInt(tokens[Categories.APPAREIL_COUT_IDX]),
                        Integer.parseInt(tokens[Categories.APPAREIL_PM_IDX]),
                        Integer.parseInt(tokens[Categories.APPAREIL_CA_IDX]),
                        tokens[Categories.APPAREIL_MOIS_IDX]
                    )
                    devices.add(device)
                }

                line = fileReader.readLine()
            }

            return devices
        }catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close()
            } catch (e: IOException) {
                println("Closing fileReader Error!")
                e.printStackTrace()
            }
        }
        return emptyList()
    }

}