package com.raqun.gadget.lib.extensions

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Promotion

/*
 * Maps Promotion to Bundle
 */
fun Promotion.toBundle(): Bundle {
    return Bundle().apply {
        put(FirebaseAnalytics.Param.ITEM_ID, id)
        put(FirebaseAnalytics.Param.ITEM_NAME, name)
        put(FirebaseAnalytics.Param.CREATIVE_NAME, creativeName)
        put(FirebaseAnalytics.Param.CREATIVE_SLOT, creativeSlot)
    }
}
