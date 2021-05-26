package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundle
import com.raqun.gadget.lib.extensions.toBundleList
import com.raqun.gadget.lib.model.Product

/*
 * Remove from Cart Event
 * Measure a product being removed from a shopping cart by logging a REMOVE_FROM_CART event
 * with an item (i.e. product) defined with the relevant fields:
 */
data class RemoveFromCartEvent(
    override val name: String = FirebaseAnalytics.Event.REMOVE_FROM_CART,
    private val product: Product,
    private val quantity: Long = 1
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            put(FirebaseAnalytics.Param.ITEMS, product.toBundle(quantity))
        }
    }
}
