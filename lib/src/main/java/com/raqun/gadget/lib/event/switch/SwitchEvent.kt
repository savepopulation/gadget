package com.raqun.gadget.lib.event.switch

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

data class SwitchEvent(
    override val name: String = Constants.Event.SWITCH,
    private val status: Boolean
) : AnalyticsEvent() {

    init {
        params[Constants.Param.STATUS] = status
    }

}
