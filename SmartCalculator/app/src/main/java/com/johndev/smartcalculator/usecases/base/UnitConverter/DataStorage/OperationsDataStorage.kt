package DataClases.DataStorage

import DataClases.DataStorage.DataStorage

open class OperationsDataStorage {

    fun megabit(megabitValue: Double): MutableList<DataStorage> {
        val megabit = 1
        val gigabit = 0.001
        val megabyte = 0.12
        val gigabyte = 0.000125
        val bit = 1000000
        val kilobit = 1000
        val kibibit = 976.56
        val mebibit = 0.95
        val gibibit = 0.000931
        val terabit = 0.000001
        val tebibit = 0.0000009094947017729282379150390625
        val petabit = 0.000000001
        val pebibit = 0.0000000008881784197001252323389053344726
        val byte = 125000
        val kilobyte = 125
        val kybibyte = 122.0703125
        val mebibyte = 0.11920928955078125
        val gibibyte = 0.000116415321826934814453125
        val terabyte = 0.000000125
        val tebibyte = 0.0000001136868377216160297393798828125
        val petabyte = 0.000000000125
        val pebibyte = 0.000000000111022302462515654042363166809
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", megabitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", megabitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", megabitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", megabitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", megabitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", megabitValue * kybibyte),
            DataStorage("Mb", "Megabit", "1 Mb", megabitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", megabitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", megabitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", megabitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", megabitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", megabitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", megabitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", megabitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", megabitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", megabitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", megabitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", megabitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", megabitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", megabitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", megabitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", megabitValue * pebibit)
        )
    }

    fun gigabit(gigabitValue: Double): MutableList<DataStorage> {
        val gigabit = 1
        val megabit = 1000
        val megabyte = 125
        val gigabyte = 0.116415321826934814453125
        val bit = 1000000000
        val kilobit = 1000000
        val kibibit = 976562.5
        val mebibit = 953.67431640625
        val gibibit = 0.931322574615478515625
        val terabit = 0.001
        val tebibit = 0.0009094947017729282379150390625
        val petabit = 0.000001
        val pebibit = 0.0000008881784197001252323389053344726562
        val byte = 125000000
        val kilobyte = 125000
        val kybibyte = 122070.3125
        val mebibyte = 119.20928955078125
        val gibibyte = 0.116415321826934814453125
        val terabyte = 0.000125
        val tebibyte = 0.0001136868377216160297393798828125
        val petabyte = 0.000000125
        val pebibyte = 0.000000111022302462515654042363166809082
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", gigabitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", gigabitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", gigabitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", gigabitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", gigabitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", gigabitValue * kybibyte),
            DataStorage("Mb", "Megabit", "1 Mb", gigabitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", gigabitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", gigabitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", gigabitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", gigabitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", gigabitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", gigabitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", gigabitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", gigabitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", gigabitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", gigabitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", gigabitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", gigabitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", gigabitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", gigabitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", gigabitValue * pebibit)
        )
    }

    fun megabyte(megabyteValue: Double): MutableList<DataStorage> {
        val gigabit = 0.008
        val megabit = 8
        val megabyte = 1
        val gigabyte = 0.001
        val bit = 8000000
        val kilobit = 8000
        val kibibit = 7812.5
        val mebibit = 7.62939453125
        val gibibit = 0.007450580596923828125
        val terabit = 0.000008
        val tebibit = 0.0000072759576141834259033203125
        val petabit = 0.000000008
        val pebibit = 0.0000000071054273576010018587112426757812
        val byte = 1000000
        val kilobyte = 1000
        val kybibyte = 976.5625
        val mebibyte = 0.95367431640625
        val gibibyte = 0.001
        val terabyte = 0.000001
        val tebibyte = 0.0000009094947017729282379150390625
        val petabyte = 0.000000001
        val pebibyte = 0.0000000008881784197001252323389053344726
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", megabyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", megabyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", megabyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", megabyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", megabyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", megabyteValue * kybibyte),
            DataStorage("Mb", "Megabit", "1 Mb", megabyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", megabyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", megabyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", megabyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", megabyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", megabyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", megabyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", megabyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", megabyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", megabyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", megabyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", megabyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", megabyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", megabyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", megabyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", megabyteValue * pebibit)
        )
    }

    fun gigabyte(gigabyteValue: Double): MutableList<DataStorage> {
        val megabit = 8000
        val gigabit = 8
        val megabyte = 1000
        val gigabyte = 1
        val bit = 8000000000
        val kilobit = 8000000
        val kibibit = 7812500
        val mebibit = 7629.39453125
        val gibibit = 7.450580596923828125
        val terabit = 0.008
        val tebibit = 0.0072759576141834259033203125
        val petabit = 0.000008
        val pebibit = 0.00000710542735760100185871124267578125
        val byte = 1000000000
        val kilobyte = 1000000
        val kibibyte = 976562.5
        val mebibyte = 953.67431640625
        val gibibyte = 0.931322574615478515625
        val terabyte = 0.001
        val tebibyte = 0.0009094947017729282379150390625
        val petabyte = 0.000001
        val pebibyte = 0.0000008881784197001252323389053344726562
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", gigabyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", gigabyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", gigabyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", gigabyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", gigabyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", gigabyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", gigabyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", gigabyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", gigabyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", gigabyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", gigabyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", gigabyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", gigabyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", gigabyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", gigabyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", gigabyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", gigabyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", gigabyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", gigabyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", gigabyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", gigabyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", gigabyteValue * pebibit)
        )
    }

    fun bit(bitValue: Double): MutableList<DataStorage> {
        val megabit = 0.000001
        val gigabit = 0.000000001
        val megabyte = 0.000000125
        val gigabyte = 0.000000000125
        val bit = 1
        val kilobit =  0.001
        val kibibit = 0.0009765625
        val mebibit = 0.00000095367431640625
        val gibibit = 0.000000000931322574615478515625
        val terabit = 0.000000000001
        val tebibit = 0.0000000000009094947017729282379150390625
        val petabit = 0.000000000000001
        val pebibit = 0.0000000000000008881784197001252323389053
        val byte = 0.125
        val kilobyte = 0.000125
        val kibibyte = 0.0001220703125
        val mebibyte = 0.00000011920928955078125
        val gibibyte = 0.000000000116415321826934814453125
        val terabyte = 0.000000000000125
        val tebibyte = 0.0000000000001136868377216160297393798828
        val petabyte = 0.000000000000000125
        val pebibyte = 0.0000000000000001110223024625156540423631
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", bitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", bitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", bitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", bitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", bitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", bitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", bitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", bitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", bitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", bitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", bitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", bitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", bitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", bitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", bitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", bitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", bitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", bitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", bitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", bitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", bitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", bitValue * pebibit)
        )
    }

    fun kilobit(kilobitValue: Double): MutableList<DataStorage> {
        val megabit = 0.001
        val gigabit = 0.000001
        val megabyte = 0.000125
        val gigabyte = 0.000000125
        val bit = 1000
        val kilobit =  1
        val kibibit = 0.9765625
        val mebibit = 0.00095367431640625
        val gibibit = 0.000000931322574615478515625
        val terabit =  0.000000001
        val tebibit = 0.0000000009094947017729282379150390625
        val petabit = 0.000000000001
        val pebibit = 0.0000000000008881784197001252323389053344
        val byte = 1000
        val kilobyte = 0.125
        val kibibyte = 0.1220703125
        val mebibyte = 0.00011920928955078125
        val gibibyte = 0.000000116415321826934814453125
        val terabyte = 0.000000000125
        val tebibyte = 0.0000000001136868377216160297393798828125
        val petabyte = 0.000000000000125
        val pebibyte = 0.0000000000001110223024625156540423631668
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", kilobitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", kilobitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", kilobitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", kilobitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", kilobitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", kilobitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", kilobitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", kilobitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", kilobitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", kilobitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", kilobitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", kilobitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", kilobitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", kilobitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", kilobitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", kilobitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", kilobitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", kilobitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", kilobitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", kilobitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", kilobitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", kilobitValue * pebibit)
        )
    }

    fun kibibit(kikibitValue: Double): MutableList<DataStorage> {
        val megabit = 0.001024
        val gigabit = 0.000001024
        val megabyte = 0.000128
        val gigabyte = 0.000000128
        val bit = 1024
        val kilobit =  1.024
        val kibibit = 1
        val mebibit = 0.0009765625
        val gibibit = 0.00000095367431640625
        val terabit =  0.000000001024
        val tebibit = 0.000000000931322574615478515625
        val petabit = 0.000000000001024
        val pebibit = 0.0000000000009094947017729282379150390625
        val byte = 128
        val kilobyte = 0.128
        val kibibyte = 0.125
        val mebibyte = 0.0001220703125
        val gibibyte = 0.00000011920928955078125
        val terabyte = 0.000000000128
        val tebibyte = 0.000000000116415321826934814453125
        val petabyte = 0.000000000000128
        val pebibyte = 0.0000000000001136868377216160297393798828
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", kikibitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", kikibitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", kikibitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", kikibitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", kikibitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", kikibitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", kikibitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", kikibitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", kikibitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", kikibitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", kikibitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", kikibitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", kikibitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", kikibitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", kikibitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", kikibitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", kikibitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", kikibitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", kikibitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", kikibitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", kikibitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", kikibitValue * pebibit)
        )
    }

    fun kilobyte(kilobyteValue: Double): MutableList<DataStorage> {
        val megabit = 0.008
        val gigabit = 0.000008
        val megabyte = 0.001
        val gigabyte = 0.000001
        val bit = 8000
        val kilobit =  8
        val kibibit = 7.8125
        val mebibit = 0.00762939453125
        val gibibit = 0.000007450580596923828125
        val terabit =  0.000000008
        val tebibit = 0.0000000072759576141834259033203125
        val petabit = 0.000000000008
        val pebibit = 0.0000000000071054273576010018587112426757
        val byte = 1000
        val kilobyte = 1
        val kibibyte = 0.9765625
        val mebibyte = 0.00095367431640625
        val gibibyte = 0.000000931322574615478515625
        val terabyte = 0.000000001
        val tebibyte = 0.0000000009094947017729282379150390625
        val petabyte = 0.000000000001
        val pebibyte = 0.0000000000008881784197001252323389053344
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", kilobyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", kilobyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", kilobyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", kilobyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", kilobyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", kilobyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", kilobyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", kilobyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", kilobyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", kilobyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", kilobyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", kilobyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", kilobyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", kilobyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", kilobyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", kilobyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", kilobyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", kilobyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", kilobyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", kilobyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", kilobyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", kilobyteValue * pebibit)
        )
    }

    fun mebibit(mebibitValue: Double): MutableList<DataStorage> {
        val megabit = 1.048576
        val gigabit = 0.001048576
        val megabyte = 0.131072
        val gigabyte = 0.000131072
        val bit = 1048576
        val kilobit =  1048.576
        val kibibit = 1024
        val mebibit = 1
        val gibibit = 0.0009765625
        val terabit =  0.000001048576
        val tebibit = 0.00000095367431640625
        val petabit = 0.000000001048576
        val pebibit = 0.000000000931322574615478515625
        val byte = 131072
        val kilobyte = 131.072
        val kibibyte = 128
        val mebibyte = 0.125
        val gibibyte = 0.0001220703125
        val terabyte = 0.000000131072
        val tebibyte = 0.00000011920928955078125
        val petabyte = 0.000000000131072
        val pebibyte = 0.000000000116415321826934814453125
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", mebibitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", mebibitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", mebibitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", mebibitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", mebibitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", mebibitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", mebibitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", mebibitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", mebibitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", mebibitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", mebibitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", mebibitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", mebibitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", mebibitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", mebibitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", mebibitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", mebibitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", mebibitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", mebibitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", mebibitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", mebibitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", mebibitValue * pebibit)
        )
    }

    fun gibibit(gibibitValue: Double): MutableList<DataStorage> {
        val megabit = 1073.741824
        val gigabit = 1.073741824
        val megabyte = 134.217728
        val gigabyte = 0.134217728
        val bit = 1073741824
        val kilobit =  1073741.824
        val kibibit = 1048576
        val mebibit = 1024
        val gibibit = 1
        val terabit =  0.001073741824
        val tebibit = 0.0009765625
        val petabit = 0.000001073741824
        val pebibit = 0.00000095367431640625
        val byte = 134217728
        val kilobyte = 134217.728
        val kibibyte = 131072
        val mebibyte = 128
        val gibibyte = 0.125
        val terabyte = 0.000134217728
        val tebibyte = 0.0001220703125
        val petabyte = 0.000000134217728
        val pebibyte = 0.00000011920928955078125
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", gibibitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", gibibitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", gibibitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", gibibitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", gibibitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", gibibitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", gibibitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", gibibitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", gibibitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", gibibitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", gibibitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", gibibitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", gibibitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", gibibitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", gibibitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", gibibitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", gibibitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", gibibitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", gibibitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", gibibitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", gibibitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", gibibitValue * pebibit)
        )
    }

    fun terabit(terabitValue: Double): MutableList<DataStorage> {
        val megabit = 1000000
        val gigabit = 1000
        val megabyte = 125000
        val gigabyte = 125
        val bit = 1000000000000
        val kilobit =  1000000000
        val kibibit = 976562500
        val mebibit = 953674.31640625
        val gibibit = 931.322574615478515625
        val terabit =  1
        val tebibit = 0.9094947017729282379150390625
        val petabit = 0.001
        val pebibit = 0.00088817841970012523233890533447265625
        val byte = 125000000000
        val kilobyte = 125000000
        val kibibyte = 122070312.5
        val mebibyte = 119209.28955078125
        val gibibyte = 116.415321826934814453125
        val terabyte = 0.125
        val tebibyte = 0.1136868377216160297393798828125
        val petabyte = 0.000125
        val pebibyte = 0.0001110223024625156540423631668090820312
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", terabitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", terabitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", terabitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", terabitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", terabitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", terabitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", terabitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", terabitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", terabitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", terabitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", terabitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", terabitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", terabitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", terabitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", terabitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", terabitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", terabitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", terabitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", terabitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", terabitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", terabitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", terabitValue * pebibit)
        )
    }

    fun tebibit(tebibitValue: Double): MutableList<DataStorage> {
        val megabit = 1099511.627776
        val gigabit = 1099.511627776
        val megabyte = 131072
        val gigabyte = 137.438953472
        val bit = 1099511627776
        val kilobit =  1099511627.776
        val kibibit = 1073741824
        val mebibit = 1048576
        val gibibit = 1024
        val terabit = 1.099511627776
        val tebibit = 1
        val petabit = 0.001099511627776
        val pebibit = 0.0009765625
        val byte = 137438953472
        val kilobyte = 137438953.472
        val kibibyte = 134217728
        val mebibyte = 131072
        val gibibyte = 128
        val terabyte = 0.137438953472
        val tebibyte = 0.125
        val petabyte = 0.000137438953472
        val pebibyte = 0.0001220703125
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", tebibitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", tebibitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", tebibitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", tebibitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", tebibitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", tebibitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", tebibitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", tebibitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", tebibitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", tebibitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", tebibitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", tebibitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", tebibitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", tebibitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", tebibitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", tebibitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", tebibitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", tebibitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", tebibitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", tebibitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", tebibitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", tebibitValue * pebibit)
        )
    }

    fun petabit(petabitValue: Double): MutableList<DataStorage> {
        val megabit = 1000000000
        val gigabit = 1000000
        val megabyte = 125000000
        val gigabyte = 125000
        val bit = 1000000000000000
        val kilobit =  1000000000000
        val kibibit = 976562500000
        val mebibit = 953674316.40625
        val gibibit = 931322.574615478515625
        val terabit = 1000
        val tebibit = 909.4947017729282379150390625
        val petabit = 1
        val pebibit = 0.88817841970012523233890533447265625
        val byte = 125000000000000
        val kilobyte = 125000000000
        val kibibyte = 122070312500
        val mebibyte = 119209289.55078125
        val gibibyte = 116415.321826934814453125
        val terabyte = 125
        val tebibyte = 113.6868377216160297393798828125
        val petabyte = 0.125
        val pebibyte = 0.11102230246251565404236316680908203125
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", petabitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", petabitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", petabitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", petabitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", petabitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", petabitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", petabitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", petabitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", petabitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", petabitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", petabitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", petabitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", petabitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", petabitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", petabitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", petabitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", petabitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", petabitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", petabitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", petabitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", petabitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", petabitValue * pebibit)
        )
    }

    fun pebibit(pebibitValue: Double): MutableList<DataStorage> {
        val megabit = 1125899906.842624
        val gigabit = 1125899.906842624
        val megabyte = 140737488.355328
        val gigabyte = 140737.488355328
        val bit = 1125899906842624
        val kilobit = 1125899906842.624
        val kibibit = 1099511627776
        val mebibit = 1073741824
        val gibibit = 1048576
        val terabit = 1125.899906842624
        val tebibit = 1024
        val petabit = 1.125899906842624
        val pebibit = 1
        val byte =  140737488355328
        val kilobyte = 140737488355.328
        val kibibyte = 137438953472
        val mebibyte = 134217728
        val gibibyte = 131072
        val terabyte = 140.737488355328
        val tebibyte = 128
        val petabyte = 0.140737488355328
        val pebibyte = 0.125
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", pebibitValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", pebibitValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", pebibitValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", pebibitValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", pebibitValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", pebibitValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", pebibitValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", pebibitValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", pebibitValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", pebibitValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", pebibitValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", pebibitValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", pebibitValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", pebibitValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", pebibitValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", pebibitValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", pebibitValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", pebibitValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", pebibitValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", pebibitValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", pebibitValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", pebibitValue * pebibit)
        )
    }

    fun byte(byteValue: Double): MutableList<DataStorage> {
        val megabit = 0.000008
        val gigabit = 0.000000008
        val megabyte = 0.000001
        val gigabyte = 0.000000001
        val bit = 8
        val kilobit = 0.008
        val kibibit = 0.0078125
        val mebibit = 0.00000762939453125
        val gibibit = 0.000000007450580596923828125
        val terabit = 0.000000000008
        val tebibit = 0.0000000000072759576141834259033203125
        val petabit = 0.000000000000008
        val pebibit = 0.0000000000000071054273576010018587112426
        val byte =  1
        val kilobyte = 0.001
        val kibibyte = 0.0009765625
        val mebibyte = 0.00000095367431640625
        val gibibyte = 0.000000000931322574615478515625
        val terabyte = 0.000000000001
        val tebibyte = 0.0000000000009094947017729282379150390625
        val petabyte = 0.000000000000001
        val pebibyte = 0.0000000000000008881784197001252323389053
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", byteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", byteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", byteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", byteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", byteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", byteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", byteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", byteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", byteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", byteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", byteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", byteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", byteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", byteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", byteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", byteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", byteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", byteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", byteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", byteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", byteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", byteValue * pebibit)
        )
    }

    fun kibibyte(kibibyteValue: Double): MutableList<DataStorage> {
        val megabit = 0.008192
        val gigabit = 0.000008192
        val megabyte = 0.001024
        val gigabyte = 0.000001024
        val bit = 8192
        val kilobit = 8.192
        val kibibit = 8
        val mebibit = 0.0078125
        val gibibit = 0.00000762939453125
        val terabit = 0.000000008192
        val tebibit = 0.000000007450580596923828125
        val petabit = 0.000000000008192
        val pebibit = 0.0000000000072759576141834259033203125
        val byte =  1024
        val kilobyte = 1.024
        val kibibyte = 1
        val mebibyte = 0.0009765625
        val gibibyte = 0.00000095367431640625
        val terabyte = 0.000000001024
        val tebibyte = 0.000000000931322574615478515625
        val petabyte = 0.000000000001024
        val pebibyte = 0.0000000000009094947017729282379150390625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", kibibyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", kibibyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", kibibyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", kibibyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", kibibyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", kibibyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", kibibyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", kibibyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", kibibyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", kibibyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", kibibyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", kibibyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", kibibyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", kibibyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", kibibyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", kibibyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", kibibyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", kibibyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", kibibyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", kibibyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", kibibyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", kibibyteValue * pebibit)
        )
    }

    fun mebibyte(mebibyteValue: Double): MutableList<DataStorage> {
        val megabit = 8.388608
        val gigabit = 0.008388608
        val megabyte = 1.048576
        val gigabyte = 0.001048576
        val bit = 8388608
        val kilobit = 8388.608
        val kibibit = 8192
        val mebibit = 8
        val gibibit = 0.0078125
        val terabit = 0.000008388608
        val tebibit = 0.00000762939453125
        val petabit = 0.000000008388608
        val pebibit = 0.000000007450580596923828125
        val byte =  1048576
        val kilobyte = 1048.576
        val kibibyte = 1024
        val mebibyte = 1
        val gibibyte = 0.0009765625
        val terabyte =0.000001048576
        val tebibyte = 0.00000095367431640625
        val petabyte = 0.000000001048576
        val pebibyte = 0.000000000931322574615478515625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", mebibyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", mebibyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", mebibyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", mebibyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", mebibyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", mebibyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", mebibyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", mebibyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", mebibyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", mebibyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", mebibyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", mebibyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", mebibyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", mebibyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", mebibyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", mebibyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", mebibyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", mebibyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", mebibyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", mebibyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", mebibyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", mebibyteValue * pebibit)
        )
    }

    fun gibibyte(gibibyteValue: Double): MutableList<DataStorage> {
        val megabit = 8589.934592
        val gigabit = 8.589934592
        val megabyte = 1073.741824
        val gigabyte = 1.073741824
        val bit = 8589934592
        val kilobit = 8589934.592
        val kibibit = 8388608
        val mebibit = 8192
        val gibibit = 8
        val terabit = 0.008589934592
        val tebibit = 0.0078125
        val petabit = 0.000008589934592
        val pebibit = 0.00000762939453125
        val byte =  1073741824
        val kilobyte = 1073741.824
        val kibibyte = 1048576
        val mebibyte = 1024
        val gibibyte = 1
        val terabyte = 0.001073741824
        val tebibyte = 0.0009765625
        val petabyte = 0.000001073741824
        val pebibyte = 0.00000095367431640625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", gibibyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", gibibyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", gibibyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", gibibyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", gibibyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", gibibyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", gibibyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", gibibyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", gibibyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", gibibyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", gibibyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", gibibyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", gibibyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", gibibyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", gibibyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", gibibyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", gibibyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", gibibyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", gibibyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", gibibyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", gibibyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", gibibyteValue * pebibit)
        )
    }

    fun terabyte(terabyteValue: Double): MutableList<DataStorage> {
        val megabit = 8000000
        val gigabit = 8000
        val megabyte = 1000000
        val gigabyte = 1000
        val bit = 8000000000000
        val kilobit = 8000000000
        val kibibit = 7812500000
        val mebibit = 7629394.53125
        val gibibit = 7450.580596923828125
        val terabit = 8
        val tebibit = 7.2759576141834259033203125
        val petabit = 0.008
        val pebibit = 0.00710542735760100185871124267578125
        val byte =  1000000000000
        val kilobyte = 1000000000
        val kibibyte = 976562500
        val mebibyte = 953674.31640625
        val gibibyte = 931.322574615478515625
        val terabyte = 1
        val tebibyte = 0.9094947017729282379150390625
        val petabyte = 0.001
        val pebibyte = 0.00088817841970012523233890533447265625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", terabyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", terabyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", terabyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", terabyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", terabyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", terabyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", terabyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", terabyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", terabyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", terabyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", terabyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", terabyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", terabyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", terabyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", terabyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", terabyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", terabyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", terabyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", terabyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", terabyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", terabyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", terabyteValue * pebibit)
        )
    }

    fun tebibyte(tebibyteValue: Double): MutableList<DataStorage> {
        val megabit = 8796093.022208
        val gigabit = 8796.093022208
        val megabyte = 1099511.627776
        val gigabyte = 1099.511627776
        val bit = 8796093022208
        val kilobit = 8796093022.208
        val kibibit = 8589934592
        val mebibit = 8388608
        val gibibit = 8192
        val terabit = 8.796093022208
        val tebibit = 8
        val petabit = 0.008796093022208
        val pebibit = 0.0078125
        val byte =  1099511627776
        val kilobyte = 1099511627.776
        val kibibyte = 1073741824
        val mebibyte = 1048576
        val gibibyte = 1024
        val terabyte = 1.099511627776
        val tebibyte = 1
        val petabyte = 0.001099511627776
        val pebibyte = 0.0009765625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", tebibyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", tebibyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", tebibyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", tebibyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", tebibyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", tebibyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", tebibyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", tebibyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", tebibyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", tebibyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", tebibyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", tebibyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", tebibyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", tebibyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", tebibyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", tebibyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", tebibyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", tebibyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", tebibyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", tebibyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", tebibyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", tebibyteValue * pebibit)
        )
    }

    fun petabyte(petabyteValue: Double): MutableList<DataStorage> {
        val megabit = 8000000000
        val gigabit = 8000000
        val megabyte = 1000000000
        val gigabyte = 1000000
        val bit = 8000000000000000
        val kilobit = 8000000000000
        val kibibit = 7812500000000
        val mebibit = 7629394531.25
        val gibibit = 7450580.596923828125
        val terabit = 8000
        val tebibit = 7275.9576141834259033203125
        val petabit = 8
        val pebibit = 7.10542735760100185871124267578125
        val byte =  1000000000000000
        val kilobyte = 1000000000000
        val kibibyte = 976562500000
        val mebibyte = 953674316.40625
        val gibibyte = 931322.574615478515625
        val terabyte = 1000
        val tebibyte = 909.4947017729282379150390625
        val petabyte = 1
        val pebibyte = 0.88817841970012523233890533447265625
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", petabyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", petabyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", petabyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", petabyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", petabyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", petabyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", petabyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", petabyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", petabyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", petabyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", petabyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", petabyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", petabyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", petabyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", petabyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", petabyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", petabyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", petabyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", petabyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", petabyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", petabyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", petabyteValue * pebibit)
        )
    }

    fun pebibyte(pebibyteValue: Double): MutableList<DataStorage> {
        val megabit = 9007199254.740992
        val gigabit = 8388608
        val megabyte = 1125899906.842624
        val gigabyte = 1125899.906842624
        val bit = 9007199254740992
        val kilobit = 9007199254740.992
        val kibibit = 8796093022208
        val mebibit = 8589934592
        val gibibit = 8388608
        val terabit = 9007.199254740992
        val tebibit = 8192
        val petabit = 9.007199254740992
        val pebibit = 8
        val byte =  1125899906842624
        val kilobyte = 1125899906842.624
        val kibibyte = 1099511627776
        val mebibyte = 1073741824
        val gibibyte = 1048576
        val terabyte = 1125.899906842624
        val tebibyte = 1024
        val petabyte = 1.125899906842624
        val pebibyte = 1
        return mutableListOf(
            DataStorage("Bit", "Bit", "1.00E-6 Mb", pebibyteValue * bit),
            DataStorage("B", "Byte", "8.00E-6 Mb", pebibyteValue * byte),
            DataStorage("Kb", "Kilobit", "0.001 Mb", pebibyteValue * kilobit),
            DataStorage("Kib", "Kibibit", "0.0001024 Mb", pebibyteValue * kibibit),
            DataStorage("KB", "Kilobyte", "0.01 Mb", pebibyteValue * kilobyte),
            DataStorage("Kib", "Kybibyte", "0.01 Mb", pebibyteValue * kibibyte),
            DataStorage("Mb", "Megabit", "1 Mb", pebibyteValue * megabit),
            DataStorage("Mib", "Mebibit", "1.05 Mb", pebibyteValue * mebibit),
            DataStorage("Mb", "Megabyte", "8 Mb", pebibyteValue * megabyte),
            DataStorage("Mib", "Mebibyte", "8.39 Mb", pebibyteValue * mebibyte),
            DataStorage("Gb", "Gigabit", "1,000 Mb", pebibyteValue * gigabit),
            DataStorage("Gib", "Gibibit", "1,073.74 Mb", pebibyteValue * gibibit),
            DataStorage("Gb", "Gigabyte", "8,000 Mb", pebibyteValue * gigabyte),
            DataStorage("Gib", "Gibibyte", "8,589.93 Mb", pebibyteValue * gibibyte),
            DataStorage("Tb", "Terabit", "1,000,000 Mb", pebibyteValue * terabit),
            DataStorage("Tib", "Tebibit", "1,099,511.63 Mb", pebibyteValue * tebibit),
            DataStorage("TB", "Terabyte", "8,000,000 Mb", pebibyteValue * terabyte),
            DataStorage("Tib", "Tebibyte", "8,796,093.02 Mb", pebibyteValue * tebibyte),
            DataStorage("Pib", "Pebibyte", "9,007,199,254.74 Mib", pebibyteValue * pebibyte),
            DataStorage("PB", "Petabyte", "8,000,000,000 Mb", pebibyteValue * petabyte),
            DataStorage("Pb", "Petabit", "1,000,000,000 Mb", pebibyteValue * petabit),
            DataStorage("Pib", "Pebibit", "1,125,899,906.84 Mb", pebibyteValue * pebibit)
        )
    }

}