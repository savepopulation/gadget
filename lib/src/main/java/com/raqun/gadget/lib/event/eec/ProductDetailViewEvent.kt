package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

class ProductDetailViewEvent(
    override val name: String = FirebaseAnalytics.Event.VIEW_ITEM
) : AnalyticsEvent(), EecEvent {

}