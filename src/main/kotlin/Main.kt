import kotlin.system.exitProcess

fun main() {
    // Инициализация объектов пиццерий для разных городов
    val pizzaPetersburg = PizzaInPetersburg(
        175.0, 241.5,
        167.5, 215.0
    )
    val pizzaMoscow = PizzaInMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    val pizzaNovgorod = PizzaInNovgorod(
        210.0, 240.5,
        170.5, 230.0
    )

    // Переменная для текущей выбранной пиццерии
    var currentPizzaInCity: PizzaInCity

    // Основной цикл программы
    while (true) {
        // Вывод меню выбора города
        println("Добрый день! Выберите город")
        println("1. Москва\n2. Санкт-Петербург\n3. Ярославль\n0. Выход из программы")

        // Обработка выбора города
        currentPizzaInCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPetersburg
            "3" -> pizzaNovgorod
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }

        // Вывод меню выбора пиццы
        println("\nВыберите пиццу:")
        println(
            "1. Неаполитанская пицца\n" +
                    "2. Римская пицца\n" +
                    "3. Сицилийская пицца\n" +
                    "4. Тирольская пицца\n" +
                    "0. Показать статистику"
        )
        // Обработка выбора пиццы
        selectPizza(currentPizzaInCity)
    }
}

// Функция для выбора пиццы и вызова соответствующих действий
private fun selectPizza(
    currentPizzaInCity: PizzaInCity
) {
    // Обработка выбора пользователя
    when (readln()) {
        "1" -> {
            currentPizzaInCity.neapolitanPizzaSale()
            selectAddService(currentPizzaInCity, "neapolitanPizza")
        }

        "2" -> {
            currentPizzaInCity.romanPizzaSale()
            selectAddService(currentPizzaInCity, "romanPizza")
        }

        "3" -> {
            currentPizzaInCity.sicilianPizzaSale()
            selectAddService(currentPizzaInCity, "sicilianPizza")
        }

        "4" -> {
            currentPizzaInCity.tyroleanPizzaSale()
            selectAddService(currentPizzaInCity, "tyroleanPizza")
        }

        "0" -> currentPizzaInCity.showStatistics()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

// Функция для выбора дополнительных услуг пиццерии
fun selectAddService(
    currentPizzaInCity: PizzaInCity,
    currentPizza: String
) {
    // Обработка выбора дополнительных услуг
    when {
        currentPizzaInCity is Drink && currentPizzaInCity is CheckPhoto && currentPizzaInCity is SauceSelector -> {
            currentPizzaInCity.drinkSale(currentPizza)
            currentPizzaInCity.showCheckPhoto()
            currentPizzaInCity.selectSauce()
        }

        currentPizzaInCity is CheckPhoto -> currentPizzaInCity.showCheckPhoto()
        currentPizzaInCity is Drink -> currentPizzaInCity.drinkSale(currentPizza)
    }
}