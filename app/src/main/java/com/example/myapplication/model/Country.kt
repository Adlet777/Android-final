package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val Country: String,
    val ISO2: String,
    val Slug: String
) : Parcelable