package com.github.juanmougan.shopping_cart

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import spark.Spark.*

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()

    before("/*") { _, res -> res.type("application/json") }
    patch("/carts/:cart_id/items") { req, res ->
        val itemsReq = mapper.readValue<List<Item>>(req.body())
        val items = listOf<Item>()      // TODO fetch list of items from ItemController by barcode
        // val cart = Cart()            // TODO update Cart with the list (in the Service)
        res.status(200)
        mapper.writeValueAsString(items)
    }
}
