package com.raqun.gadget.lib.tracker

import android.content.Context
import com.raqun.gadget.lib.event.Event

/*
 * Defines Gadget's general tracking methods
 */
interface AnalyticsTracker {
    /*
     * Setup tracker
     */
    fun setup(context: Context, customEventTracker: EventTracker? = null)

    /*
     * Event tracking method
     */
    fun track(event: Event, eventTracker: EventTracker? = null)
}
