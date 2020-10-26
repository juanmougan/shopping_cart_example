package com.github.juanmougan.shopping_cart.item_api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import spark.Spark.*
import java.util.*

fun main(args: Array<String>) {
    val mapper = jacksonObjectMapper()

    before("/*") { _, res -> res.type("application/json") }
    get("/items") { req, res -> "TODO serialize items here" }
    post("/items") { req, res ->
        val item = mapper.readValue<Item>(req.body())
        // TODO save the thing
        item.id = UUID.randomUUID()
        res.status(201)
        mapper.writeValueAsString(item)
    }
}
