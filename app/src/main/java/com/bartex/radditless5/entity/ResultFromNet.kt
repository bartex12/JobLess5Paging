package com.bartex.radditless5.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

//за @Parcelize отвечает plugins с id 'kotlin-android-extensions'
// за @Expose отвечает implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
@Parcelize
data class ResultFromNet (
    @Expose val kind:String? = null,
    @Expose val data:MainData? = null
): Parcelable