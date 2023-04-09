class ShoppingItem(val itemName: String, val itemQuantity: Int, val itemPrice: Double) {
    var totalPrice: Double = 0.0
        private set

    init {
        calculateTotalPrice()
    }

    private fun calculateTotalPrice() {
        totalPrice = itemQuantity * itemPrice
    }
}
