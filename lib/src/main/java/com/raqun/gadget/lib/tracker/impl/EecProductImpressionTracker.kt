package com.raqun.gadget.lib.tracker.impl

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.eec.ProductImpressionEvent
import com.raqun.gadget.lib.event.eec.ProductSelectionEvent
import com.raqun.gadget.lib.model.Product
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.ListItemImpressionTracker
import com.raqun.gadget.lib.tracker.LifecycleEventTracker

class EecProductImpressionTracker(
    override val lifeCycle: Lifecycle,
    override val viewedItems: LinkedHashSet<Product> = linkedSetOf(),
    override val analyticsTracker: AnalyticsTracker,
    override val eventName: String = FirebaseAnalytics.Event.VIEW_ITEM_LIST,
    override val listName: String
) : ListItemImpressionTracker<Product>,
    LifecycleObserver,
    LifecycleEventTracker {

    init {
        lifeCycle.addObserver(this)
    }

    override fun trackItemSelection(item: Product) {
        val selectionEvent = ProductSelectionEvent(
            product = item,
            itemListName = listName
        )
        analyticsTracker.track(selectionEvent)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun trackImpression() {
        if (viewedItems.isNullOrEmpty()) return
        val productImpressionEvent = ProductImpressionEvent(
            itemListName = eventName,
            products = viewedItems.toList()
        )
        analyticsTracker.track(productImpressionEvent)
        viewedItems.clear()
    }
}
