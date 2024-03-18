// Интерфейс для работы с фотографией чека
interface CheckPhoto {
    var countChecksShown: Int  // Количество показанных фотографий чека
    var totalDiscount: Int  // Общая сумма скидок

    // Функция для отображения фотографии чека
    fun showCheckPhoto()
}
