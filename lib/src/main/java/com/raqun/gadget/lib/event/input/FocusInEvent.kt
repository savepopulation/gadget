package com.raqun.gadget.lib.event.input

import com.raqun.gadget.lib.Constants

/*
 * Generic input area focus in event
 */
data class FocusInEvent(
    private val eventName: String = Constants.Event.FOCUS_IN,
    private val isValid: Boolean? = null
) : InputEvent(eventName, isValid)

