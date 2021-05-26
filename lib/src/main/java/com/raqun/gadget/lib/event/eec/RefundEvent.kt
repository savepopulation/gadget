package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundleList
import com.raqun.gadget.lib.model.RefundedProduct

/*
 * Refunds
 * Measure refunds by logging a PURCHASE_REFUND event with the relevant transaction ID specified,
 * and optionally (for partial refunds) one or more items
 * (i.e. products) defined with item IDs and quantities.
 */
data class RefundEvent(
    override val name: String = FirebaseAnalytics.Event.REFUND,
    private val products: List<RefundedProduct>? = null,
    private val transactionId: String,
    private val value: Double
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            products?.let { refundedProducts ->
                putParcelableArrayList(
                    FirebaseAnalytics.Param.ITEMS,
                    refundedProducts.toBundleList()
                )
            }
            put(FirebaseAnalytics.Param.TRANSACTION_ID, transactionId)
            put(FirebaseAnalytics.Param.VALUE, value)
        }
    }
}
