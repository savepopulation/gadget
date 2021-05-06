package com.raqun.gadget.lib.tracker.impl

import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.tracker.EventTracker

open class DefaultEventTracker(private val firebaseEventTracker: EventTracker) : EventTracker {

    override fun track(event: Event) {
        firebaseEventTracker.track(event)
    }
}
