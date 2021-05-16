package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Checkout options
 * Measure checkout options after a checkout step by logging a SET_CHECKOUT_OPTION event
 * with the corresponding CHECKOUT_STEP and CHECKOUT_OPTION parameters:
 */
data class CheckoutOptionsEvent(
    override val name: String = FirebaseAnalytics.Event.SET_CHECKOUT_OPTION
) : AnalyticsEvent(), EecEvent
