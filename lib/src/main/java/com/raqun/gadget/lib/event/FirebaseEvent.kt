package com.raqun.gadget.lib.event

import android.os.Bundle
import com.raqun.gadget.lib.extensions.put

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
        if (params.isNotEmpty()) {
            for (param in this.params) {
                bundle.put(param.key, param.value)
            }
        }

        return bundle
    }
}
