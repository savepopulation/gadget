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

    /*
     * Puts the parameter with the given key and value
     */
    fun putParam(key: String, value: Any?) {
        params[key] = value
    }

    /*
     * Puts all the params git the given key and value
     */
    fun putParams(params: Map<String, Any?>) {
        if (!params.isNullOrEmpty()) {
            this.params.putAll(params)
        }
    }
}
