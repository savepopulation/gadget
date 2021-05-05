package com.raqun.gadget.lib

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.impl.DefaultEventTracker
import com.raqun.gadget.lib.tracker.EventTracker
import com.raqun.gadget.lib.tracker.impl.FirebaseEventTracker

object Gadget : AnalyticsTracker {

    private lateinit var defaultEventTracker: EventTracker

    @Synchronized
    override fun setup(context: Context, customEventTracker: EventTracker?) {
        defaultEventTracker = if (customEventTracker != null) {
            customEventTracker
        } else {
            val firebaseEventTracker: EventTracker =
                FirebaseEventTracker(FirebaseAnalytics.getInstance(context.applicationContext))
            DefaultEventTracker(firebaseEventTracker)
        }
    }

    override fun track(ev: Event, eventTracker: EventTracker?) {
        eventTracker?.track(ev) ?: defaultEventTracker.track(ev)
    }
}
