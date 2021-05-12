package com.raqun.gadget.lib.tracker

import androidx.lifecycle.Lifecycle

/*
 * Defines a tracker is binds with lifecycle
 */
interface LifecycleEventTracker {
    /*
     * Lifecycle
     */
    val lifeCycle: Lifecycle
}
