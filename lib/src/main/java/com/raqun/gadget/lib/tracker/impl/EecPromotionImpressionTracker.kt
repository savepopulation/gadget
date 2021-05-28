package com.raqun.gadget.lib.tracker.impl

import com.raqun.gadget.lib.Gadget
import com.raqun.gadget.lib.event.eec.PromotionImpressionEvent
import com.raqun.gadget.lib.event.eec.PromotionSelectionEvent
import com.raqun.gadget.lib.model.Promotion
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.ListItemImpressionTracker

/*
 * EEC Promotion Impression Tracker
 * Can be used to track promotion impressions and selections for EEC
 */
class EecPromotionImpressionTracker(
    override val analyticsTracker: AnalyticsTracker = Gadget,
    override val viewedItems: LinkedHashSet<Promotion> = linkedSetOf(),
    private val eventName: String,
    private val contentType: String
) : ListItemImpressionTracker<Promotion> {

    override fun trackItemSelection(item: Promotion) {
        val promotions = ArrayList<Promotion>()
        promotions.add(item)

        val promotionSelectionEvent = PromotionSelectionEvent(
            promotions = promotions,
            promotionId = item.id,
            contentType = contentType
        )

        analyticsTracker.track(promotionSelectionEvent)
    }

    override fun trackImpression() {
        if (viewedItems.isNullOrEmpty()) return
        val promotionImpressionEvent = PromotionImpressionEvent(
            name = eventName,
            promotions = viewedItems.toList()
        )
        analyticsTracker.track(promotionImpressionEvent)
        viewedItems.clear()
    }
}
