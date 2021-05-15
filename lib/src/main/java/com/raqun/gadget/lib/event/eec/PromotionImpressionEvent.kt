package com.raqun.gadget.lib.event.eec

import com.raqun.gadget.lib.domain.Promotion
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Promotion Impression Event
 * Measure promotion impressions by logging a VIEW_ITEM, VIEW_ITEM_LIST,
 * or VIEW_SEARCH_RESULTS event with a promotion item defined with the relevant fields:
 */
data class PromotionImpressionEvent(
    override val name: String,
    private val promotions: List<Promotion>
) : AnalyticsEvent(), EecEvent