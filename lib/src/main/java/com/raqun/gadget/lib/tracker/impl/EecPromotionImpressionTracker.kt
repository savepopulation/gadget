package com.raqun.gadget.lib.tracker.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.raqun.gadget.lib.Gadget
import com.raqun.gadget.lib.event.eec.PromotionImpressionEvent
import com.raqun.gadget.lib.event.eec.PromotionSelectionEvent
import com.raqun.gadget.lib.model.Promotion
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.LifecycleEventTracker
import com.raqun.gadget.lib.tracker.ListItemImpressionTracker

/*
 * EEC Promotion Impression Tracker
 * Can be used to track promotion impressions and selections for EEC
 */
class EecPromotionImpressionTracker(
    override val lifeCycle: Lifecycle,
    override val analyticsTracker: AnalyticsTracker = Gadget,
    override val viewedItems: LinkedHashSet<Promotion> = linkedSetOf(),
    private val eventName: String,
    private val contentType: String,
) : ListItemImpressionTracker<Promotion>,
    LifecycleObserver,
    LifecycleEventTracker {

    init {
        lifeCycle.addObserver(this)
    }

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

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
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
