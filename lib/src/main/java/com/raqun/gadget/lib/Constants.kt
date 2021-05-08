package com.raqun.gadget.lib

/*
 * Contains the Gadget Library Constants
 */
class Constants private constructor() {
    /*
     * Contains generic event names
     */
    object Event {
        const val CLICK = "click"
        const val FOCUS_IN = "focus_in"
        const val FOCUS_OUT = "focus_out"

        object Error {
            const val API_ERROR = "api_error"
            const val BUSINESS_ERROR = "business_error"
        }
    }

    /*
     * Contains parameter names
     */
    object Param {
        const val CODE = "code"
        const val MESSAGE = "message"
        const val TYPE = "type"
        const val SCREEN_NAME = "screen_name"
        const val ENDPOINT = "endpoint"
        const val CLASS = "class_name"
        const val IS_VALID = "is_Valid"
    }
}
