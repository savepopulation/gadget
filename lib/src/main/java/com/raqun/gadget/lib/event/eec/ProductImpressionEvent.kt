package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.domain.Product
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundleList

data class ProductImpressionEvent(
    override val name: String = FirebaseAnalytics.Event.VIEW_ITEM_LIST,
    private val products: List<Product>,
    private val itemListName: String
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            putParcelableArrayList(
                FirebaseAnalytics.Param.ITEMS,
                products.toBundleList(putIndex = true)
            )
            put(FirebaseAnalytics.Param.ITEM_LIST_NAME, itemListName)
        }
    }
}
