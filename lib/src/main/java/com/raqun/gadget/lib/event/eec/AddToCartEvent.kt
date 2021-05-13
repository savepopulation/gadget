package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

class AddToCartEvent(
    override val name: String = FirebaseAnalytics.Event.ADD_TO_CART
) : AnalyticsEvent(), EecEvent {
}