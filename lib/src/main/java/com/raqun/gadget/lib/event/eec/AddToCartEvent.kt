package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.domain.Product
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.putQuantity
import com.raqun.gadget.lib.extensions.toBundle

/*
 * Add to Cart Event
 * Measure a product being added to a shopping cart by logging an ADD_TO_CART event
 * with an item (i.e. product) defined with the relevant fields.
 */
data class AddToCartEvent(
    override val name: String = FirebaseAnalytics.Event.ADD_TO_CART,
    private val product: Product,
    private val quantity: Long = 1
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            put(Constants.Param.ITEMS, product.toBundle().putQuantity(quantity))
        }
    }
}
