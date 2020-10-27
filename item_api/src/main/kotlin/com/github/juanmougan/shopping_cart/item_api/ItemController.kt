package com.github.juanmougan.shopping_cart.item_api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import spark.Spark.*

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()

    before("/*") { _, res -> res.type("application/json") }
    post("/items") { req, res ->
        val itemReq = mapper.readValue<Item>(req.body())
        val item = ItemService.add(itemReq)
        res.status(201)
        mapper.writeValueAsString(item)
    }
    get("/items") { req, res ->
        val barcode = req.queryParams("barcode")
        try {
            val itemMatchingBarcode = ItemService.findByBarcode(barcode)
            mapper.writeValueAsString(itemMatchingBarcode)
        } catch (e: NoSuchElementException) {
            res.status(404)
            mapper.writeValueAsString(Error("barcode", "Barcode $barcode not found"))
        }
    }
}
