package com.github.juanmougan.shopping_cart.item_api

import java.util.*

/**
 * Simple fake in-memory representation of a service (plus a repository)
 */
object ItemService {
    private val ITEMS: MutableMap<UUID, Item> = mutableMapOf()

    fun add(item: Item): Item {
        item.id = UUID.randomUUID()
        ITEMS[item.id!!] = item
        return item
    }

    fun findByBarcode(barcode: String): Item {
        return ITEMS.values.first { it.barcode == barcode }
    }
}