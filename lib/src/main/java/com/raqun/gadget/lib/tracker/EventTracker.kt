package com.raqun.gadget.lib.tracker

import com.raqun.gadget.lib.event.Event

/*
 * Defines the general event tracker
 */
interface EventTracker {
    /*
     * Tracking function
     * Tracks the given event
     */
    fun track(event: Event)
}
