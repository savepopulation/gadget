package com.raqun.gadget.lib.event.error

import com.raqun.gadget.lib.Constants
import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Generic Error Event to catch and log the errors in the app
 */
sealed class ErrorEvent(
    private val code: String,
    private val message: String,
    private val type: String?,
    private val screenName: String? = null,
) : AnalyticsEvent() {

    init {
        params[Constants.Param.CODE] = code
        params[Constants.Param.MESSAGE] = message
        params[Constants.Param.SCREEN_NAME] = screenName
        params[Constants.Param.TYPE] = type
    }

    /*
     * Generic Api Error event to log api errors in the app
     */
    data class ApiErrorEvent(
        override val name: String = Constants.Event.API_ERROR,
        private val code: String,
        private val message: String,
        private val screenName: String? = null,
        private val type: String? = ApiErrorEvent::class.simpleName,
        private val endpoint: String? = null
    ) : ErrorEvent(
        code = code,
        message = message,
        type = type,
        screenName = screenName,
    ) {
        init {
            params[Constants.Param.ENDPOINT] = endpoint
        }
    }
}
