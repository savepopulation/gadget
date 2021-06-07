package com.raqun.gadget.lib.tracker.impl

import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.tracker.EventTracker

/*
 * Default Event Tracker
 * Used default while tracking events by Gadget.
 * By default all events are going to be tracked to Firebase
 */
open class DefaultEventTracker(private val firebaseEventTracker: EventTracker) : EventTracker {
    /*
     * Default event tracking method
     */
    override fun track(event: Event) {
        firebaseEventTracker.track(event)
    }
}
