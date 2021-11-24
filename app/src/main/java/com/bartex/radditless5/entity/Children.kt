package com.bartex.radditless5.entity

import com.google.gson.annotations.Expose

data class Children(
    @Expose val kind:String? = null,
    @Expose val data:ChildrenData? = null
){
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val children: Children =
            o as Children
        return data?.title == children.data?.title &&
                data?. author == children.data?.author &&
                data?.thumbnail == children.data?.thumbnail
    }
}
