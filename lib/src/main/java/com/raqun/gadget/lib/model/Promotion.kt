package com.raqun.gadget.lib.model

/*
 * Promotion
 * Used for to track promotion related EEC events
 */
data class Promotion(
    val id: String,
    val name: String,
    val creativeName: String? = null,
    val creativeSlot: String? = null
)
