package com.raqun.gadget.lib.event.eec

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent
import com.raqun.gadget.lib.extensions.put
import com.raqun.gadget.lib.extensions.toBundle
import com.raqun.gadget.lib.model.Promotion

/*
 * Promotion clicks/selections
 * Measure promotion clicks by logging a SELECT_CONTENT event
 * with a promotion defined with the relevant fields:
 */
data class PromotionSelectionEvent(
    override val name: String = FirebaseAnalytics.Event.SELECT_CONTENT,
    private val promotions: List<Promotion>,
    private val promotionId: String,
    private val contentType: String
) : AnalyticsEvent(), EecEvent {

    override fun toBundle(): Bundle {
        return Bundle().apply {
            putParcelableArrayList(Constants.Param.PROMOTIONS, promotions.toBundle())
            put(FirebaseAnalytics.Param.ITEM_ID, promotionId)
            put(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
        }
    }
}
