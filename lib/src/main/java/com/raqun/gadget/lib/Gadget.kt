package com.raqun.gadget.lib

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.impl.DefaultEventTracker
import com.raqun.gadget.lib.tracker.EventTracker
import com.raqun.gadget.lib.tracker.impl.FirebaseEventTracker

/*
 * Gadget is a customizable analytics tracking tool
 */
object Gadget : AnalyticsTracker {
    /*
     * Default Event Tracker
     * Will be used by default while tracking events
     */
    private lateinit var defaultEventTracker: EventTracker

    /*
     * Call once in your application class to setup Gadget
     */
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

    /*
     * Track method to track events
     * Event tracker parameter is null by default.
     * If event tracker parameter is null the default event tracker will be used
     * for tracking events.
     */
    override fun track(event: Event, eventTracker: EventTracker?) {
        eventTracker?.track(event) ?: defaultEventTracker.track(event)
    }
}
