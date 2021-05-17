package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Refunds
 * Measure refunds by logging a PURCHASE_REFUND event with the relevant transaction ID specified,
 * and optionally (for partial refunds) one or more items
 * (i.e. products) defined with item IDs and quantities.
 */
data class RefundEvent(
    override val name: String = FirebaseAnalytics.Event.REFUND
) : AnalyticsEvent(), EecEvent