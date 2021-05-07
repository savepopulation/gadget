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
) : AnalyticsEvent() {

    init {
        params[Constants.Param.CODE] = code
        params[Constants.Param.MESSAGE] = message
        params[Constants.Param.TYPE] = type
    }

    /*
     * Generic Api Error event to log api errors in the app
     */
    data class ApiErrorEvent(
        override val name: String = Constants.Event.Error.API_ERROR,
        private val code: String,
        private val message: String,
        private val screenName: String? = null,
        private val type: String? = ApiErrorEvent::class.simpleName,
        private val endpoint: String? = null
    ) : ErrorEvent(
        code = code,
        message = message,
        type = type
    ) {
        init {
            params[Constants.Param.ENDPOINT] = endpoint
            params[Constants.Param.SCREEN_NAME] = screenName
        }
    }

    /*
     * Generic Business Error event to track errors in business layer
     */
    data class BusinessErrorEvent(
        override val name: String = Constants.Event.Error.BUSINESS_ERROR,
        private val code: String,
        private val message: String,
        private val type: String? = BusinessErrorEvent::class.simpleName,
    ) : ErrorEvent(
        code = code,
        message = message,
        type = type
    )
}
