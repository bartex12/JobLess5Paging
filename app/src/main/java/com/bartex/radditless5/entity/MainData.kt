package com.bartex.radditless5.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MainData(
    @Expose val after:String? = null,
    @Expose val before:String? = null,
    @Expose val dist:Int? = 0,
    @Expose val children:@RawValue List<Children>? = null
):Parcelable
