package com.kottage.model

import java.util.*

data class Site(val name:String, val details:Map<String,Response>)
data class Response(var stat:Status = Status.DOWN, var change:Date = Date)
enum class Status{
    UP,DOWN,UNRESPONSIVE
}