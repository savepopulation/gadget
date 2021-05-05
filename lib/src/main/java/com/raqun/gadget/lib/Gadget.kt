package com.raqun.gadget.lib

import android.content.Context
import com.raqun.gadget.lib.event.Event
import com.raqun.gadget.lib.tracker.AnalyticsTracker
import com.raqun.gadget.lib.tracker.DefaultEventTracker
import com.raqun.gadget.lib.tracker.EventTracker

object Gadget : AnalyticsTracker {

    private var defaultEventTracker: EventTracker = DefaultEventTracker()

    @Synchronized
    override fun setup(context: Context, customEventTracker: EventTracker?) {
        customEventTracker?.let {
            this.defaultEventTracker = it
        }
    }

    override fun track(ev: Event, eventTracker: EventTracker?) {
        eventTracker?.track(ev) ?: defaultEventTracker.track(ev)
    }
}
