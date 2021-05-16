package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Begin checkout
 * Measure the first step in a checkout process by logging a BEGIN_CHECKOUT event
 * with one or more items (i.e. products) defined with the relevant fields.
 */
data class BeginCheckoutEvent(
    override val name: String = FirebaseAnalytics.Event.BEGIN_CHECKOUT
) : AnalyticsEvent(), EecEvent