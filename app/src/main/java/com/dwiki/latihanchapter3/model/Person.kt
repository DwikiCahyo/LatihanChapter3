package com.dwiki.latihanchapter3.model

import java.io.Serializable

data class Person(
    val name:String,
    val email:String,
    val phone:String,
    val address:String,
    val age:Int
):Serializable
