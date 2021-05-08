package com.raqun.gadget.lib.event.input

import com.raqun.gadget.lib.Constants

/*
 * Generic input area focus out event
 */
data class FocusOutEvent(
    private val eventName: String = Constants.Event.FOCUS_OUT,
    private val isValid: Boolean? = null
) : InputEvent(eventName, isValid)
