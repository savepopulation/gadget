package com.raqun.gadget.lib.event.eec

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Product Detail View Event
 * Measure product detail views by logging a VIEW_ITEM event
 * with an item (i.e. product) defined with the relevant fields:
 */
data class ProductDetailViewEvent(
    override val name: String = FirebaseAnalytics.Event.VIEW_ITEM
) : AnalyticsEvent(), EecEvent