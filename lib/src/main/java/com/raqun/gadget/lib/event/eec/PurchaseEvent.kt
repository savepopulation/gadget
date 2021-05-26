package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundleList
import com.raqun.gadget.lib.model.Product

/*
 * Purchases
 * Measure purchases by logging an ECOMMERCE_PURCHASE event
 * with one or more items (i.e. products) defined with the relevant fields.
 */
data class PurchaseEvent(
    override val name: String = FirebaseAnalytics.Event.PURCHASE,
    private val products: List<Product>,
    private val transactionId: String,
    private val affiliation: String,
    private val value: Double,
    private val tax: Double,
    private val shipping: Double,
    private val currency: String,
    private val coupon: String
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            putParcelableArrayList(FirebaseAnalytics.Param.ITEMS, products.toBundleList())
            put(FirebaseAnalytics.Param.TRANSACTION_ID, transactionId)
            put(FirebaseAnalytics.Param.AFFILIATION, affiliation)
            put(FirebaseAnalytics.Param.VALUE, value)
            put(FirebaseAnalytics.Param.TAX, tax)
            put(FirebaseAnalytics.Param.SHIPPING, shipping)
            put(FirebaseAnalytics.Param.CURRENCY, currency)
            put(FirebaseAnalytics.Param.COUPON, coupon)
        }
    }
}
