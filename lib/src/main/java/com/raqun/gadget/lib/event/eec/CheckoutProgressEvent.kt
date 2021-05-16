package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Additional checkout steps
 * Measure additional steps in a checkout process by logging a CHECKOUT_PROGRESS event
 * with one or more items (i.e. products) defined with the relevant fields.
 */
data class CheckoutProgressEvent(
    override val name: String = FirebaseAnalytics.Event.CHECKOUT_PROGRESS
) : AnalyticsEvent(), EecEvent
