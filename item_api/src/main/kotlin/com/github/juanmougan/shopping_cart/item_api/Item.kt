package com.github.juanmougan.shopping_cart.item_api

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Item(
    var id: UUID?,
    var name: String,
    var description: String,
    var price: BigDecimal
)
