package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.event.FirebaseEvent

class ProductImpressionEvent(
    override val name: String = FirebaseAnalytics.Event.VIEW_ITEM_LIST
) : AnalyticsEvent(), EecEvent {

}