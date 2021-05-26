package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.model.Promotion
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.toBundle

/*
 * Promotion Impression Event
 * Measure promotion impressions by logging a VIEW_ITEM, VIEW_ITEM_LIST,
 * or VIEW_SEARCH_RESULTS event with a promotion item defined with the relevant fields:
 */
data class PromotionImpressionEvent(
    override val name: String,
    private val promotions: List<Promotion>
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            putParcelableArrayList(Constants.Param.POSITION, promotions.toBundle())
        }
    }
}
