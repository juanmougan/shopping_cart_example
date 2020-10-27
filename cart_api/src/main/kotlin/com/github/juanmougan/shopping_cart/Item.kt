package com.github.juanmougan.shopping_cart

import java.math.BigDecimal
import java.util.*

data class Item(
    var id: UUID,
    var name: String,
    var description: String,
    var price: BigDecimal,
    var barcode: String     // maybe?
)
