package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.event.FirebaseEvent

/*
 * Promotion clicks/selections
 * Measure promotion clicks by logging a SELECT_CONTENT event
 * with a promotion defined with the relevant fields:
 */
data class PromotionSelectionEvent(
    override val name: String = FirebaseAnalytics.Event.SELECT_CONTENT
) : AnalyticsEvent(), EecEvent