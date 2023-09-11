package dtos

import entity.Product

data class ProductResponse(
    val id: Long?,
    val name: String,
    val price: Long,
    val qty: Int
)

fun Product.toResponse() = ProductResponse(
    id = id,
    name = name,
    price = price,
    qty = qty
)
