package com.raqun.gadget.lib.event.input

import com.raqun.gadget.lib.Constants

data class FocusInEvent(private val eventName: String = Constants.Event.FOCUS_IN) :
    InputEvent(eventName)
