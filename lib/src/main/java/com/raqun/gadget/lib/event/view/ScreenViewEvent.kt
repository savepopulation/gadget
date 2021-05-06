package com.raqun.gadget.lib.event.view

import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Firebase ScreenView Event
 * Screen Name is the name of the screen that is going to be tracked
 * Class Name is the name of the class that is going to be tracked
 */
data class ScreenViewEvent(
    val screenName: String,
    val className: String
) : AnalyticsEvent() {

    override val name: String = FirebaseAnalytics.Event.SCREEN_VIEW

    init {
        params[FirebaseAnalytics.Param.SCREEN_NAME] = this.screenName
        params[FirebaseAnalytics.Param.SCREEN_CLASS] = this.className
    }

}
