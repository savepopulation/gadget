package com.raqun.gadget.lib.event.switch

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Generic switch event to track switch status changes in the app
 */
data class SwitchEvent(
    override val name: String = Constants.Event.SWITCH,
    private val status: Boolean
) : AnalyticsEvent() {

    init {
        params[Constants.Param.STATUS] = status
    }

}
