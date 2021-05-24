package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Product
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundle

/*
 * Product Detail View Event
 * Measure product detail views by logging a VIEW_ITEM event
 * with an item (i.e. product) defined with the relevant fields:
 */
data class ProductDetailViewEvent(
    override val name: String = FirebaseAnalytics.Event.VIEW_ITEM,
    private val product: Product
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            put(FirebaseAnalytics.Param.ITEMS, product.toBundle())
        }
    }
}
