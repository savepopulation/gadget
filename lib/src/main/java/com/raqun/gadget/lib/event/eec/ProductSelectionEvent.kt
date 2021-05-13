package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

data class ProductSelectionEvent(
    override val name: String = FirebaseAnalytics.Event.SELECT_CONTENT
) : AnalyticsEvent(), EecEvent {

}
