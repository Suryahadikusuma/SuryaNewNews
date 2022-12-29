package com.suryahadi.newsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
/**
 * untuk memprentasikan entity dari Source.
 */
@Parcelize
data class Source(
    val id: String,
    val name: String
):Parcelable