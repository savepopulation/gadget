package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

data class RemoveFromCart(
    override val name: String = FirebaseAnalytics.Event.REMOVE_FROM_CART
) : AnalyticsEvent() {

}