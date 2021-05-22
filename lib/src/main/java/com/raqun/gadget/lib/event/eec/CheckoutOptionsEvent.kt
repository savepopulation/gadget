package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put

/*
 * Checkout options
 * Measure checkout options after a checkout step by logging a SET_CHECKOUT_OPTION event
 * with the corresponding CHECKOUT_STEP and CHECKOUT_OPTION parameters:
 */
data class CheckoutOptionsEvent(
    override val name: String = FirebaseAnalytics.Event.SET_CHECKOUT_OPTION,
    private val checkoutStep: Long,
    private val checkoutOption: String
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            put(FirebaseAnalytics.Param.CHECKOUT_STEP, checkoutStep)
            put(FirebaseAnalytics.Param.CHECKOUT_OPTION, checkoutOption)
        }
    }
}
