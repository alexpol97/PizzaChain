// Абстрактный класс, представляющий пиццерию в городе
abstract class PizzaInCity(
    private val neapolitanPizzaPrice: Double,
    private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double,
    private val tyroleanPizzaPrice: Double
) {
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0
    var countCustomers = 0

    // Абстрактные методы для продажи различных видов пицц
    abstract fun neapolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    // Абстрактный метод для получения дополнительной выручки, например, за дополнительные услуги
    abstract fun getAdditionMoney(): Int

    // Открытый метод для вывода статистики по продажам
    open fun showStatistics() {
        println("--Статистика по пиццам--:")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        // Вычисление общей суммы выручки
        val money = sicilianPizzaCount * sicilianPizzaPrice +
                neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice + getAdditionMoney()

        println("Всего заработано денег: $money")
    }
}
