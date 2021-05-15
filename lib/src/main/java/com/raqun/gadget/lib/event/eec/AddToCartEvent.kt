package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Add to Cart Event
 * Measure a product being added to a shopping cart by logging an ADD_TO_CART event
 * with an item (i.e. product) defined with the relevant fields.
 */
data class AddToCartEvent(
    override val name: String = FirebaseAnalytics.Event.ADD_TO_CART
) : AnalyticsEvent(), EecEvent