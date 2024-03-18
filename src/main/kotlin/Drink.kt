// Интерфейс для представления напитков
interface Drink {
    var countCoffee: Int  // Общее количество проданных чашек кофе
    var totalCoffeeMoney: Int  // Общая выручка от продажи кофе

    // Функция, вызываемая при продаже напитка к пицце
    fun drinkSale(currentPizza: String)
}