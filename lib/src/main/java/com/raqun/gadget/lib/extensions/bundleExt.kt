/*
 * Contains extensions about Bundle operations
 */
package com.raqun.gadget.lib.extensions

import android.os.Bundle
import android.os.Parcelable
import com.google.firebase.analytics.FirebaseAnalytics
import java.io.Serializable
import java.util.Date

/*
 * Puts the value with the given key to a Budnle
 */
fun <T> Bundle.put(key: String, value: T?) {

    // by default null values is not sending to Firebase
    if (value == null) return

    when (value) {
        is Boolean -> putBoolean(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Short -> putShort(key, value)
        is Long -> putLong(key, value)
        is Byte -> putByte(key, value)
        is ByteArray -> putByteArray(key, value)
        is Char -> putChar(key, value)
        is CharArray -> putCharArray(key, value)
        is CharSequence -> putCharSequence(key, value)
        is Float -> putFloat(key, value)
        is Bundle -> putBundle(key, value)
        is Parcelable -> putParcelable(key, value)
        is Serializable -> putSerializable(key, value)
        is Date -> putSerializable(key, value)
        is Enum<*> -> putString(key, value.name)
        else -> throw IllegalStateException("Type of property with the given $key is not supported!")
    }
}

/*
 * Puts Index to the bundle
 */
fun Bundle.putIndex(index: Long): Bundle {
    put(FirebaseAnalytics.Param.INDEX, index)
    return this
}
