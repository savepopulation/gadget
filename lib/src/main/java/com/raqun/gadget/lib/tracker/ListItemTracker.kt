package com.raqun.gadget.lib.tracker

import androidx.arch.core.util.Function

/*
 * List Item Tracker
 * Used for tracking impression or selection of items in a list
 */
interface ListItemTracker<T> {
    /*
     * Tracker
     */
    val analyticsTracker: AnalyticsTracker

    /*
     * Contains viewed items
     */
    val viewedItems: MutableSet<T>

    /*
     * Function to track item impression
     * Call when item is viewed
     */
    fun addImpression(item: T) {
        viewedItems.add(item)
    }

    /*
     * Function to track item impression with a mapper
     * Call when item is viewed
     */
    fun addImpression(item: Any?, mapper: Function<Any, T>) {
        item?.let {
            viewedItems.add(mapper.apply(it))
        }
    }

    /*
     * Tracks selection of an item in a list
     */
    fun trackItemSelection(item: T)

    /*
     * Tracks the item impression
     */
    fun trackImpression()
}
