package com.bartex.radditless5.entity

import com.google.gson.annotations.Expose

data class Children(
    @Expose val kind:String? = null,
    @Expose val data:ChildrenData? = null
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val children: Children =
            other as Children
        return data?.title == children.data?.title &&
                data?. author == children.data?.author &&
                data?.ups == children.data?.ups
    }

    override fun hashCode(): Int {
        var result = kind?.hashCode() ?: 0
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }
}
