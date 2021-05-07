package com.raqun.gadget.lib.event

/*
 * Analytics Event
 * Abstraction of general analytics event that can be tracked by the library
 * Ideally, an event should be tracked to Firebase by default.
 */
abstract class AnalyticsEvent(final override val params: MutableMap<String, Any?> = mutableMapOf()) :
    FirebaseEvent
