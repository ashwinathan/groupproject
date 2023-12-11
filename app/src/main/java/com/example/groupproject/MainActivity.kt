package com.example.groupproject

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    private lateinit var locationGroup1: RadioGroup
    private lateinit var greenbeltL : RadioButton
    private lateinit var collegeParkL : RadioButton
    private lateinit var hyattsvillecrossingL : RadioButton
    private lateinit var westhyattsvilleL : RadioButton
    private lateinit var forttottenL : RadioButton
    private lateinit var georgiaavepetworthL : RadioButton
    private lateinit var columbiaheightsL : RadioButton
    private lateinit var ustL : RadioButton
    private lateinit var locationGroup2: RadioGroup
    private lateinit var shawhowarduL : RadioButton
    private lateinit var mtvernonsqL : RadioButton
    private lateinit var galleryplaceL : RadioButton
    private lateinit var judiciarysqL : RadioButton
    private lateinit var unionstationL : RadioButton
    private lateinit var nomagallaudetuL : RadioButton
    private lateinit var rhodeislandaveL : RadioButton
    private lateinit var brooklandcuaL : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location)

        trains = Trains(this)

        locationGroup1 = findViewById(R.id.locationGroup1)
        greenbeltL = findViewById(R.id.greenbeltL)
        collegeParkL = findViewById(R.id.collegeparkL)
        hyattsvillecrossingL = findViewById(R.id.hyattsvillecrossingL)
        westhyattsvilleL = findViewById(R.id.westhyattsvilleL)
        forttottenL = findViewById(R.id.forttottenL)
        georgiaavepetworthL = findViewById(R.id.georgiaavepetworthL)
        columbiaheightsL = findViewById(R.id.columbiaheightsL)
        ustL = findViewById(R.id.ustL)
        locationGroup2 = findViewById(R.id.locationGroup2)
        shawhowarduL = findViewById(R.id.shawhowarduL)
        mtvernonsqL = findViewById(R.id.mtvernonsqL)
        galleryplaceL = findViewById(R.id.galleryplaceL)
        judiciarysqL = findViewById(R.id.judiciarysqL)
        unionstationL = findViewById(R.id.unionstationL)
        nomagallaudetuL = findViewById(R.id.nomagallaudetuL)
        rhodeislandaveL = findViewById(R.id.rhodeislandaveL)
        brooklandcuaL = findViewById(R.id.brooklandcuaL)

        var locationListener = CheckedChangeListener(locationGroup1, locationGroup2)
        locationGroup1.setOnCheckedChangeListener(locationListener)
        locationGroup2.setOnCheckedChangeListener(locationListener)

        if (trains.getLocation() != "none") {
            var loc = trains.getLocation()

            for (index in 0 until locationGroup1.childCount) {
                var button = locationGroup1.getChildAt(index) as RadioButton
                if (loc == button.text.toString()) {
                    button.isChecked = true
                }
            }

            for (index in 0 until locationGroup2.childCount) {
                var button = locationGroup2.getChildAt(index) as RadioButton
                if (loc == button.text.toString()) {
                    button.isChecked = true
                }
            }
        }

    }

    fun locationSubmit(v : View) {
        var check = true

        if (locationGroup1.checkedRadioButtonId != -1) {
            location = findViewById<RadioButton?>(locationGroup1.checkedRadioButtonId).text.toString()
        } else if (locationGroup2.checkedRadioButtonId != -1){
            location = findViewById<RadioButton?>(locationGroup2.checkedRadioButtonId).text.toString()
        } else {
            check = false
        }

        if (check) {
            var intent = Intent(this, DestinationActivity::class.java)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }

    inner class CheckedChangeListener : RadioGroup.OnCheckedChangeListener {
        private val radioGroup1: RadioGroup
        private val radioGroup2: RadioGroup

        constructor(group1: RadioGroup, group2: RadioGroup) {
            radioGroup1 = group1
            radioGroup2 = group2
        }

        private var lastCheckedRadioGroup: RadioGroup? = null

        override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
            if (lastCheckedRadioGroup != null && lastCheckedRadioGroup != group && checkedId != -1) {
                lastCheckedRadioGroup!!.clearCheck()
            }
            if (checkedId != -1) {
                lastCheckedRadioGroup = group
            }
        }
    }

    companion object {
        lateinit var trains : Trains
        lateinit var location : String
    }
}