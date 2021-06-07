package com.raqun.gadget.lib.tracker.impl

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.event.FirebaseEvent
import com.raqun.gadget.lib.tracker.EventTracker

/*
 * Firebase Event Tracker
 * If the given event is a Firebase event, event will be tracked to Firebase with
 * it's bundle implementation.
 */
open class FirebaseEventTracker(private val firebaseAnalytics: FirebaseAnalytics) : EventTracker {

    override fun track(event: Event) {
        if (event is FirebaseEvent) {
            firebaseAnalytics.logEvent(event.name, event.toBundle())
        }
    }
}
