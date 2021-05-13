package com.raqun.gadget.lib.domain

typealias ProductMapper = (Any?) -> Product?

/*
 * Product data class that will be tracked wit EEC Events
 */
data class Product(
    val id: String?,
    val name: String?,
    val category: String?,
    val variant: String?,
    val brand: String?,
    val price: Double?,
    val currency: String?,
    val index: Int
)