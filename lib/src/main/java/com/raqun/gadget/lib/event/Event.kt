package com.raqun.gadget.lib.event

/*
 * Event
 * Generic Event interface
 * Every event has a name and params
 */
interface Event {
    /*
     * Event name
     */
    val name: String

    /*
     * Event parameters
     */
    val params: MutableMap<String, Any?>
}
