package com.raqun.gadget.lib.extensions

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Product

/*
 * Puts product to a bundle for logging to Firebase
 */
fun Product.toBundle(): Bundle {
    return Bundle().apply {
        put(FirebaseAnalytics.Param.ITEM_ID, id)
        put(FirebaseAnalytics.Param.ITEM_NAME, name)
        put(FirebaseAnalytics.Param.ITEM_CATEGORY, category)
        put(FirebaseAnalytics.Param.ITEM_BRAND, brand)
        put(FirebaseAnalytics.Param.PRICE, price)
        put(FirebaseAnalytics.Param.CURRENCY, currency)
        put(FirebaseAnalytics.Param.ITEM_VARIANT, variant)
        put(FirebaseAnalytics.Param.INDEX, index)
    }
}

/*
 * Puts list of products to a bundle
 */
fun List<Product>.toBundleList(putIndex: Boolean = false): ArrayList<Bundle> {
    val productBundleList = ArrayList<Bundle>()
    this.forEachIndexed { index, product ->
        val productBundle = product.toBundle()
        if (putIndex) {
            productBundle.putIndex(index.toLong())
        }
        productBundleList.add(productBundle)
    }
    return productBundleList
}
