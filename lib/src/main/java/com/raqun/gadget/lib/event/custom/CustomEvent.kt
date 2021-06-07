package com.raqun.gadget.lib.event.custom

import com.raqun.gadget.lib.event.AnalyticsEvent

/*
 * Custom Event can be used to track custom events with initial params
 */
data class CustomEvent(
    override val name: String,
    private val initialParams: MutableMap<String, Any?> = mutableMapOf()
) : AnalyticsEvent() {

    init {
        if (!initialParams.isNullOrEmpty()) {
            params.putAll(initialParams)
        }
    }
}
