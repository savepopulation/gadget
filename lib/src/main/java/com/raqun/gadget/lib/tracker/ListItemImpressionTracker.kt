package com.raqun.gadget.lib.tracker

import androidx.arch.core.util.Function

/*
 * List Item Tracker
 * Used for tracking impression or selection of items in a list
 * Measure product impressions by logging event with an ITEM_LIST parameter
 * and one or more items (i.e. products) defined with the relevant fields.
 */
interface ListItemImpressionTracker<T> {
    /*
     * Tracker
     */
    val analyticsTracker: AnalyticsTracker

    /*
     * Contains viewed items
     */
    val viewedItems: MutableSet<T>

    /*
     * Event Name
     */
    val eventName: String

    /*
     * Name of the list
     */
    val listName: String

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
     * Measure product clicks by logging a SELECT_CONTENT event
     * with an item (i.e. product) defined with the relevant fields:
     */
    fun trackItemSelection(item: T)

    /*
     * Tracks the item impression
     */
    fun trackImpression()
}
