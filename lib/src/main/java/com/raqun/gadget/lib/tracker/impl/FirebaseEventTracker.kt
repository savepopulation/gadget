package com.raqun.gadget.lib.tracker.impl

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.event.FirebaseEvent
import com.raqun.gadget.lib.tracker.EventTracker

open class FirebaseEventTracker(private val firebaseAnalytics: FirebaseAnalytics) : EventTracker {

    override fun track(event: Event) {
        if (event is FirebaseEvent) {
            firebaseAnalytics.logEvent(event.name, event.toBundle())
        }
    }
}
