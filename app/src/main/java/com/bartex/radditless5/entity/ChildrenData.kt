package com.bartex.radditless5.entity

import com.google.gson.annotations.Expose

data class ChildrenData(
    @Expose val subreddit_name_prefixed:String? = null, //13 сообщество
    @Expose val title:String? = null, //20 заголовок
    @Expose val ups:Int = 0, //36 просмотры
    @Expose val total_awards_received:Int = 0, //37 кол-во наград
    @Expose val thumbnail:String? = null, //54 картинка если есть
    @Expose val author:String? = null, //2000 никнэйм
    @Expose val num_comments:Int = 0, //2002  количество комментов
    @Expose val created:Float = 0f //создан
){

}
