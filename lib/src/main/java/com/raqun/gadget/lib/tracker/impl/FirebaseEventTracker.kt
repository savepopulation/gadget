package com.raqun.gadget.lib.tracker.impl

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.event.FirebaseEvent
import com.raqun.gadget.lib.tracker.EventTracker

class FirebaseEventTracker(private val firebaseAnalytics: FirebaseAnalytics) : EventTracker {

    override fun track(ev: Event) {
        if (ev is FirebaseEvent) {
            firebaseAnalytics.logEvent(ev.name, ev.toBundle())
        }
    }
}
