package com.raqun.gadget.lib.event.custom

import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Custom Event can be used to track custom events with initial params
 */
data class CustomEvent(
    override val name: String,
    override val params: MutableMap<String, Any?> = mutableMapOf()
) : AnalyticsEvent()
