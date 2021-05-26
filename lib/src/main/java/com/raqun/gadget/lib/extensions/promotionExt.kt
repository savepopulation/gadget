package com.raqun.gadget.lib.extensions

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Promotion

/*
 * Maps Promotion to Bundle
 */
fun Promotion.toBundleList(): Bundle {
    return Bundle().apply {
        put(FirebaseAnalytics.Param.ITEM_ID, id)
        put(FirebaseAnalytics.Param.ITEM_NAME, name)
        put(FirebaseAnalytics.Param.CREATIVE_NAME, creativeName)
        put(FirebaseAnalytics.Param.CREATIVE_SLOT, creativeSlot)
    }
}

/*
 * Maps the promotion list to bundle list
 */
fun List<Promotion>.toBundleList(): ArrayList<Bundle> {
    val promotionsBundle = ArrayList<Bundle>()
    this.forEach {
        promotionsBundle.add(it.toBundleList())
    }

    return promotionsBundle
}
