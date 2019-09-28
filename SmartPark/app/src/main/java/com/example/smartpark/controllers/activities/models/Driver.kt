package com.example.smartpark.controllers.activities.models

import org.json.JSONObject
import java.io.Serializable

data class Driver(
    var id:Int,
    var fullName:String,
    var email:String,
    var dni:Long,
    var celular:Long
): Serializable{
    constructor(): this(
        0,
        "",
        "",
        0,
        0
    )
    fun convertToJson():JSONObject{
        val jsonDriver = JSONObject()
        jsonDriver.put("id",id)
        jsonDriver.put("fullName", fullName)
        jsonDriver.put("email", email)
        jsonDriver.put("dni", dni)
        jsonDriver.put("celular", celular)

        return jsonDriver
    }

}
