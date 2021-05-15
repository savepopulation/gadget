package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Remove from Cart Event
 * Measure a product being removed from a shopping cart by logging a REMOVE_FROM_CART event
 *  with an item (i.e. product) defined with the relevant fields:
 */
data class RemoveFromCartEvent(
    override val name: String = FirebaseAnalytics.Event.REMOVE_FROM_CART
) : AnalyticsEvent(), EecEvent
