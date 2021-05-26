package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Product
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundle
import com.raqun.gadget.lib.extensions.toBundleList

data class ProductSelectionEvent(
    override val name: String = FirebaseAnalytics.Event.SELECT_CONTENT,
    private val product: Product,
    private val itemListName: String
) : AnalyticsEvent(), EecEvent {

    // TODO put index in item list tracker implementation
    override fun toBundle(): Bundle {
        return Bundle().apply {
            put(FirebaseAnalytics.Param.ITEMS, product.toBundle())
        }
    }
}
