package com.raqun.gadget.lib.event.click

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Generic click event to track the clicks in the app
 */
data class ClickEvent(
    override val name: String = Constants.Event.CLICK
) : AnalyticsEvent()
