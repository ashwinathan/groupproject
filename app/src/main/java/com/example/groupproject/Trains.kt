package com.example.groupproject

import android.content.Context
import android.content.SharedPreferences

class Trains {
    private lateinit var location : String
    private lateinit var destination : String

    constructor(location : String, destination : String) {
        this.location = location
        this.destination = destination
    }

    constructor(context : Context) {
        var pref : SharedPreferences = context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)
        setLocation(pref.getString("location", "none").toString())
        setDestination(pref.getString("destination", "none").toString())
    }

    fun setPreferences(context : Context) {
        var pref : SharedPreferences = context.getSharedPreferences(context.packageName + "_preferences", Context.MODE_PRIVATE)

        var editor : SharedPreferences.Editor = pref.edit()
        editor.putString("location", destination)
        editor.putString("destination", location)
        editor.commit()
    }


    fun getLocation() : String {
        return location
    }

    fun getDestination() : String {
        return destination
    }

    fun setLocation(location : String) {
        this.location = location
    }

    fun setDestination(destination : String) {
        this.destination = destination
    }
}