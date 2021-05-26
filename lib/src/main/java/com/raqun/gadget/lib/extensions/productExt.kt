package com.raqun.gadget.lib.extensions

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.raqun.gadget.lib.model.Product
import com.raqun.gadget.lib.model.RefundedProduct

/*
 * Puts product to a bundle for logging to Firebase
 */
fun Product.toBundle(q: Long? = null): Bundle {
    return Bundle().apply {
        put(FirebaseAnalytics.Param.ITEM_ID, id)
        put(FirebaseAnalytics.Param.ITEM_NAME, name)
        put(FirebaseAnalytics.Param.ITEM_CATEGORY, category)
        put(FirebaseAnalytics.Param.ITEM_BRAND, brand)
        put(FirebaseAnalytics.Param.PRICE, price)
        put(FirebaseAnalytics.Param.CURRENCY, currency)
        put(FirebaseAnalytics.Param.ITEM_VARIANT, variant)
        put(FirebaseAnalytics.Param.QUANTITY, quantity ?: q)
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

/*
 * Puts refunded product to bundle
 */
fun RefundedProduct.toBundle(): Bundle {
    return Bundle().apply {
        put(FirebaseAnalytics.Param.ITEM_ID, id)
        put(FirebaseAnalytics.Param.QUANTITY, quantity)
    }
}

/*
 * Puts list of refunded products into bundle
 */
fun List<RefundedProduct>.toBundleList(): ArrayList<Bundle> {
    val refundedProductBundleList = ArrayList<Bundle>()
    this.forEach {
        refundedProductBundleList.add(it.toBundle())
    }
    return refundedProductBundleList
}