// Интерфейс для выбора соусов к пицце
interface SauceSelector {
    val saucePrices: Map<String, Int>  // Цены на соусы
    val sauceStatistics: MutableMap<String, Int>  // Статистика по проданным соусам

    // Функция для выбора соуса
    fun selectSauce() {
        println("Выберите соус:")
        println("1. Томатный соус")
        println("2. Сливочный соус")

        when (readln()) {
            "1" -> {
                val sauce = "Томатный соус"
                sauceStatistics[sauce] = sauceStatistics.getOrDefault(sauce, 0) + 1
            }

            "2" -> {
                val sauce = "Сливочный соус"
                sauceStatistics[sauce] = sauceStatistics.getOrDefault(sauce, 0) + 1
            }

            else -> {
                println("Некорректный выбор, используется томатный соус по умолчанию.")
                val sauce = "Томатный соус"
                sauceStatistics[sauce] = sauceStatistics.getOrDefault(sauce, 0) + 1
            }
        }
    }

    // Функция для получения цены за конкрентный соус
    fun getSaucePrice(sauce: String): Int {
        return saucePrices[sauce] ?: 0
    }

    // Функция для получения выручки от продажи соусов
    fun getSauceRevenue(): Int {
        return sauceStatistics.entries.sumOf { (sauce, count) -> getSaucePrice(sauce) * count }
    }
}
