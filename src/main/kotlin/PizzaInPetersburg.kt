// Класс представляющий пиццерию в Санкт-Петербурге
class PizzaInPetersburg(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaInCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), Drink {

    // Мапа для отслеживания количества кофе к каждому виду пиццы
    var pizzaCoffee = mutableMapOf<String, Int>(
        "neapolitanPizza" to 0,
        "romanPizza" to 0,
        "sicilianPizza" to 0,
        "tyroleanPizza" to 0
    )

    // Переменные для отслеживания количества проданных кофе и общей выручки от продажи кофе
    override var countCoffee = 0
    override var totalCoffeeMoney = 0

    // Вывод статистики по продажам кофе к каждому виду пиццы
    fun showStatisticCoffee() {
        println("Кофе к неапольтанской пицце купили ${pizzaCoffee["neapolitanPizza"]} из $neapolitanPizzaCount = ${if (neapolitanPizzaCount != 0) "${pizzaCoffee["neapolitanPizza"]!!.toInt() * 100 / neapolitanPizzaCount}%" else "0%"}")
        println("Кофе к римской пицце купили ${pizzaCoffee["romanPizza"]} из $romanPizzaCount = ${if (romanPizzaCount != 0) "${pizzaCoffee["romanPizza"]!!.toInt() * 100 / romanPizzaCount}%" else "0%"}")
        println("Кофе к сицилийской пицце купили ${pizzaCoffee["sicilianPizza"]} из $sicilianPizzaCount = ${if (sicilianPizzaCount != 0) "${pizzaCoffee["sicilianPizza"]!!.toInt() * 100 / sicilianPizzaCount}%" else "0%"}")
        println("Кофе к тирольской пицце купили ${pizzaCoffee["tyroleanPizza"]} из $tyroleanPizzaCount = ${if (tyroleanPizzaCount != 0) "${pizzaCoffee["tyroleanPizza"]!!.toInt() * 100 / tyroleanPizzaCount}%" else "0%"}")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    // Метод для реализации продажи напитка к пицце
    override fun drinkSale(currentPizza: String) {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            countCoffee++
            totalCoffeeMoney += 200
            println("С вас 200 рублей")
            pizzaCoffee[currentPizza] = pizzaCoffee[currentPizza]!!.plus(1)
        }
        countCustomers++
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
        println("--Статистика по соотношению кофе-пицца--:")
        showStatisticCoffee()
    }

    // Реализация метода для получения дополнительной выручки (в данном случае за кофе)
    override fun getAdditionMoney(): Int {
        return totalCoffeeMoney
    }
}
