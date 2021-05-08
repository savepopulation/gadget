package com.raqun.gadget.lib.event.input

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Generic Input event
 */
open class InputEvent(
    override val name: String,
    isValid: Boolean? = null
) : AnalyticsEvent() {

    init {
        params[Constants.Param.IS_VALID] = isValid
    }

}
