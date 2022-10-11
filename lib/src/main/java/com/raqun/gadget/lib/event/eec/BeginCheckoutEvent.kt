package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Product
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundleList

/*
 * Begin checkout
 * Measure the first step in a checkout process by logging a BEGIN_CHECKOUT event
 * with one or more items (i.e. products) defined with the relevant fields.
 */
data class BeginCheckoutEvent(
    override val name: String = FirebaseAnalytics.Event.BEGIN_CHECKOUT,
    private val products: List<Product>
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            putParcelableArrayList(FirebaseAnalytics.Param.ITEMS, products.toBundleList())
        }
    }
}
