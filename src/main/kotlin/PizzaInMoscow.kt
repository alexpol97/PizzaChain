// Класс представляющий пиццерию в Москве
class PizzaInMoscow(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaInCity(
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto {

    // Переменные для отслеживания количества показанных чеков и общей суммы скидок
    override var countChecksShown: Int = 0
    override var totalDiscount: Int = 0

    // Реализация методов продажи различных видов пиццы
    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("Спасибо за покупку неаполитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    // Реализация метода для показа фотографии чека
    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            totalDiscount += 50
            countChecksShown++
            println("Вам будет скидка 50 рублей")
        }
        countCustomers++
    }

    // Реализация метода для вывода статистики
    override fun showStatistics() {
        super.showStatistics()
        println()
        println("--Статистика по чекам--:")
        println("Количество покупателей: $countCustomers")
        println("Количество показов фотографии чека: $countChecksShown")
        println("Количество человек без фотографии чека: ${countCustomers - countChecksShown}")
        println("Процент показов фотографии чека: ${countChecksShown * 100 / countCustomers}%")
        println("Общая сумма скидок: $totalDiscount")
    }

    // Реализация метода для получения дополнительной выручки (в данном случае отрицательной, так как это скидка)
    override fun getAdditionMoney(): Int {
        return -totalDiscount
    }
}
