// Класс представляющий пиццерию в Ярославле
class PizzaInNovgorod(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaInCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink, CheckPhoto, SauceSelector {

    // Мапа для хранения цен на соусы
    override val saucePrices: Map<String, Int> = mapOf(
        "Томатный соус" to 35,
        "Сливочный соус" to 30
    )

    // Мапа для хранения статистики по продажам соусов
    override val sauceStatistics: MutableMap<String, Int> = mutableMapOf()

    // Переменные для отслеживания количества показанных чеков и общей суммы скидок
    override var countChecksShown: Int = 0
    override var totalDiscount: Int = 0

    // Мапа для хранения статистики по продажам кофе к разным видам пиццы
    var pizzaCoffee = mutableMapOf(
        "neapolitanPizza" to 0,
        "romanPizza" to 0,
        "sicilianPizza" to 0,
        "tyroleanPizza" to 0
    )

    // Переменные для отслеживания количества проданных кофе и общей выручки от продажи кофе
    override var countCoffee = 0
    override var totalCoffeeMoney = 0

    // Метод для отображения статистики по продажам кофе
    fun showStatisticCoffee() {
        println("Кофе к неапольтанской пицце купили ${pizzaCoffee["neapolitanPizza"]} из $neapolitanPizzaCount = ${if (neapolitanPizzaCount != 0) "${pizzaCoffee["neapolitanPizza"]!!.toInt() * 100 / neapolitanPizzaCount}%" else "0%"}")
        println("Кофе к римской пицце купили ${pizzaCoffee["romanPizza"]} из $romanPizzaCount = ${if (romanPizzaCount != 0) "${pizzaCoffee["romanPizza"]!!.toInt() * 100 / romanPizzaCount}%" else "0%"}")
        println("Кофе к сицилийской пицце купили ${pizzaCoffee["sicilianPizza"]} из $sicilianPizzaCount = ${if (sicilianPizzaCount != 0) "${pizzaCoffee["sicilianPizza"]!!.toInt() * 100 / sicilianPizzaCount}%" else "0%"}")
        println("Кофе к тирольской пицце купили ${pizzaCoffee["tyroleanPizza"]} из $tyroleanPizzaCount = ${if (tyroleanPizzaCount != 0) "${pizzaCoffee["tyroleanPizza"]!!.toInt() * 100 / tyroleanPizzaCount}%" else "0%"}")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Ярославле")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Ярославле")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Ярославле")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Ярославле")
    }

    // Метод для реализации продажи напитка к пицце
    override fun drinkSale(currentPizza: String) {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            countCoffee++
            totalCoffeeMoney += 200
            println("С вас 200 реблей")
            pizzaCoffee[currentPizza] = pizzaCoffee[currentPizza]!!.plus(1)
        }
        countCustomers++
    }

    // Метод для реализации показа фотографии чека
    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            totalDiscount += 50
            countChecksShown++
            println("Вам будет скидка 50 рублей")
        }
    }

    // Метод для отображения общей статистики по продажам
    override fun showStatistics() {
        super.showStatistics()
        println()
        println("--Статистика по кофе--:")
        println("Количество покупателей: $countCustomers")
        println("Количество проданных кофе: $countCoffee")
        println("Количество отказов от кофе: ${countCustomers - countCoffee}")
        println("Процент купленного кофе: ${countCoffee * 100 / countCustomers}%")
        println("Общая сумма выручки за кофе: $totalCoffeeMoney")

        println()
        println("--Статистика по чекам--:")
        println("Количество покупателей: $countCustomers")
        println("Количество показов фотографии чека: $countChecksShown")
        println("Количество человек без фотографии чека: ${countCustomers - countChecksShown}")
        println("Процент показов фотографии чека: ${countChecksShown * 100 / countCustomers}%")
        println("Общая сумма скидок: $totalDiscount")

        println()
        println("--Статистика по соотношению кофе-пицца--:")
        showStatisticCoffee()

        println()
        println("--Статистика по соусам--:")
        sauceStatistics.forEach { (sauce, count) ->
            println("Продано $sauce: $count шт. Выручка: ${getSaucePrice(sauce) * count}")
        }

        val totalSauceRevenue = getSauceRevenue()
        println("Общая выручка за соусы: $totalSauceRevenue")
        println()
    }

    // Метод для получения общей выручки (кофе, скидки, соусы)
    override fun getAdditionMoney(): Int {
        return +totalCoffeeMoney - totalDiscount + getSauceRevenue()
    }
}
