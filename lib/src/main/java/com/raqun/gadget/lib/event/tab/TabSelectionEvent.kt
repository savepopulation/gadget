package com.raqun.gadget.lib.event.tab

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Generic tab selection event to track tab selections in the app
 */
data class TabSelectionEvent(
    override val name: String = Constants.Event.TAB_SELECTION,
    private val tabName: String,
    private val tabPosition: Int
) : AnalyticsEvent() {

    init {
        params[Constants.Param.NAME] = tabName
        params[Constants.Param.POSITION] = tabPosition
    }
}
