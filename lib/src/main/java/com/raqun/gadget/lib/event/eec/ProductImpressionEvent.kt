package com.raqun.gadget.lib.event.eec

import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.event.FirebaseEvent

class ProductImpressionEvent(
    override val name: String
) : AnalyticsEvent(), EecEvent {

}