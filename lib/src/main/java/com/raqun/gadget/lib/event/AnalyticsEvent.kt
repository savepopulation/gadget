package com.raqun.gadget.lib.event

/*
 * Analytics Event
 * Abstraction of general analytics event that can be tracked by the library
 * Ideally, an event should be tracked to Firebase by default.
 */
abstract class AnalyticsEvent(
    override val name: String,
    initialParams: Map<String, Any?>? = null
) : FirebaseEvent {
    /*
     * Parameters of event
     */
    final override val params: MutableMap<String, Any?> = mutableMapOf()

    init {
        if (!initialParams.isNullOrEmpty()) {
            params.putAll(initialParams)
        }
    }

    /*
     * Puts the parameter with the given key and value
     */
    fun putParam(key: String, value: Any?) {
        params[key] = value
    }
}
