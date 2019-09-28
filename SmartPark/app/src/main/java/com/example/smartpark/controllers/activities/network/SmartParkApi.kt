package com.example.smartpark.controllers.activities.network

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.smartpark.controllers.activities.models.Driver
import org.xml.sax.ErrorHandler
import java.lang.reflect.InvocationHandler

class SmartParkApi {
    companion object {
        private val BASE_URL= "https://smartparkapi.azurewebsites.net"
        private val assestmentUrl = "$BASE_URL/api/Assestment"
        private val bookingUrl = "$BASE_URL/api/Booking"
        private val driverUrl = "$BASE_URL/api/Driver"
        private val ownerUrl = "$BASE_URL/api/Owner"
        private val TAG = "SmartParkApi"
        fun getDrivers( responseHandler: (ArrayList<Driver>?)-> Unit, errorHandler: (ANError)-> Unit) {
            get(driverUrl,responseHandler,errorHandler)
        }




        private inline fun login(url: String, crossinline responseHandler: (Driver?) -> Unit,
                                crossinline  errorHandler: (ANError) -> Unit){
            AndroidNetworking.get(url)
                .addHeaders("Autorizathion","Bearer")
                .setTag(TAG)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(Driver::class.java, object : ParsedRequestListener<Driver>{
                    override fun onResponse(response: Driver?){
                        response?.apply {
                            responseHandler(response)
                        }
                    }
                    override fun onError(anError: ANError?) {
                        anError?.apply {
                            Log.d(TAG, "Error $errorCode: $errorBody $localizedMessage")
                            errorHandler(this)
                        }
                    }

                })
        }


        private inline fun <reified T> get(url: String, crossinline responseHandler: (ArrayList<T>?) -> Unit,
                                           crossinline errorHandler: (ANError) -> Unit){
            AndroidNetworking.get(url)
                .addHeaders("Autorizathion","Bearer")
                .setTag(TAG)
                .setPriority(Priority.HIGH)
                .build()
                .getAsObjectList(T::class.java, object : ParsedRequestListener<ArrayList<T>> {
                    override fun onResponse(response: ArrayList<T>){
                        response?.apply {
                            responseHandler(response)
                        }
                    }
                    override fun onError(anError: ANError?) {
                        anError?.apply {
                            Log.d(TAG, "Error $errorCode: $errorBody $localizedMessage")
                            errorHandler(this)
                        }
                    }
                }
                )

        }

    }

}