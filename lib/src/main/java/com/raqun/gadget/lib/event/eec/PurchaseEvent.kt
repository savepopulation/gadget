package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Purchases
 * Measure purchases by logging an ECOMMERCE_PURCHASE event
 * with one or more items (i.e. products) defined with the relevant fields.
 */
data class PurchaseEvent(
    override val name: String = FirebaseAnalytics.Event.PURCHASE
) : AnalyticsEvent(), EecEvent
