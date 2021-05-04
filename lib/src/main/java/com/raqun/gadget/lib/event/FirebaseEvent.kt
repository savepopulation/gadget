package com.raqun.gadget.lib.event

import android.os.Bundle

/*
 * Firebase Event
 * Defines the events that will be tracked to Firebase Analytics
 */
interface FirebaseEvent : Event {
    /*
     * Converts the event to bundle to track Firebase Analytics
     */
    fun toBundle(): Bundle {
        val bundle = Bundle()
        if (this.params.isNotEmpty()) {
            for (param in this.params) {
                // TODO put params to bundle
            }
        }

        return bundle
    }
}
