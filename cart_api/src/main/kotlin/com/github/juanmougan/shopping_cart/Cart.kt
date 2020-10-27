package com.github.juanmougan.shopping_cart

import java.util.*

data class Cart(
    var id: UUID,
    var items: List<Item>
)
