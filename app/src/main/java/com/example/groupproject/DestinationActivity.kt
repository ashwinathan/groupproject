package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.app.ActivityOptions
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.PopupWindow
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class DestinationActivity : AppCompatActivity() {
    private lateinit var destinationGroup1: RadioGroup
    private lateinit var greenbeltD : RadioButton
    private lateinit var collegeParkD : RadioButton
    private lateinit var hyattsvillecrossingD : RadioButton
    private lateinit var westhyattsvilleD : RadioButton
    private lateinit var forttottenD : RadioButton
    private lateinit var georgiaavepetworthD : RadioButton
    private lateinit var columbiaheightsD : RadioButton
    private lateinit var ustD : RadioButton
    private lateinit var destinationGroup2: RadioGroup
    private lateinit var shawhowarduD : RadioButton
    private lateinit var mtvernonsqD : RadioButton
    private lateinit var galleryplaceD : RadioButton
    private lateinit var judiciarysqD : RadioButton
    private lateinit var unionstationD : RadioButton
    private lateinit var nomagallaudetuD : RadioButton
    private lateinit var rhodeislandaveD : RadioButton
    private lateinit var brooklandcuaD : RadioButton
    private var ad : InterstitialAd? = null
    private lateinit var inflater : LayoutInflater
    private lateinit var popUp : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destination)

        inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        popUp = inflater.inflate(R.layout.results_popup, null)

        var adUnitId : String = "ca-app-pub-3940256099942544/1033173712"
        var adRequest : AdRequest = (AdRequest.Builder()).build()
        var adLoad : AdLoad = AdLoad()
        InterstitialAd.load(this, adUnitId, adRequest, adLoad)

        destinationGroup1 = findViewById(R.id.destinationGroup1)
        greenbeltD = findViewById(R.id.greenbeltD)
        collegeParkD = findViewById(R.id.collegeparkD)
        hyattsvillecrossingD = findViewById(R.id.hyattsvillecrossingD)
        westhyattsvilleD = findViewById(R.id.westhyattsvilleD)
        forttottenD = findViewById(R.id.forttottenD)
        georgiaavepetworthD = findViewById(R.id.georgiaavepetworthD)
        columbiaheightsD = findViewById(R.id.columbiaheightsD)
        ustD = findViewById(R.id.ustD)
        destinationGroup2 = findViewById(R.id.destinationGroup2)
        shawhowarduD = findViewById(R.id.shawhowarduD)
        mtvernonsqD = findViewById(R.id.mtvernonsqD)
        galleryplaceD = findViewById(R.id.galleryplaceD)
        judiciarysqD = findViewById(R.id.judiciarysqD)
        unionstationD = findViewById(R.id.unionstationD)
        nomagallaudetuD = findViewById(R.id.nomagallaudetuD)
        rhodeislandaveD = findViewById(R.id.rhodeislandaveD)
        brooklandcuaD = findViewById(R.id.brooklandcuaD)

        var destinationListener = CheckedChangeListener(destinationGroup1, destinationGroup1)
        destinationGroup1.setOnCheckedChangeListener(destinationListener)
        destinationGroup2.setOnCheckedChangeListener(destinationListener)

        if (MainActivity.trains.getDestination() != "none") {
            var dest = MainActivity.trains.getDestination()

            for (index in 0 until destinationGroup1.childCount) {
                var button = destinationGroup1.getChildAt(index) as RadioButton
                if (dest == button.text.toString()) {
                    button.isChecked = true
                }
            }

            for (index in 0 until destinationGroup2.childCount) {
                var button = destinationGroup2.getChildAt(index) as RadioButton
                if (dest == button.text.toString()) {
                    button.isChecked = true
                }
            }
        }
    }

    fun destinationSubmit(v : View) {
        var check = true
        if (destinationGroup1.checkedRadioButtonId != -1) {
            var dest = findViewById<RadioButton?>(destinationGroup1.checkedRadioButtonId).text.toString()

            if (dest == MainActivity.location) {
                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val popupView = inflater.inflate(R.layout.popup_layout, null)
                val width = 800
                val height = 800
                val focusable = true
                val popupWindow = PopupWindow(popupView, width, height, focusable)

                popupWindow.showAtLocation(greenbeltD, Gravity.CENTER, 0, 0)
                check = false
            } else {
                destination = dest
            }
        } else if (destinationGroup2.checkedRadioButtonId != -1){
            var dest = findViewById<RadioButton?>(destinationGroup2.checkedRadioButtonId).text.toString()

            if (dest == MainActivity.location) {
                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val popupView = inflater.inflate(R.layout.popup_layout, null)
                val width = 800
                val height = 800
                val focusable = true
                val popupWindow = PopupWindow(popupView, width, height, focusable)

                popupWindow.showAtLocation(greenbeltD, Gravity.CENTER, 0, 0)
                check = false
            } else {
                destination = dest
            }
        } else {
            check = false
        }

        if (check) {
            val width = 1200
            val height = 1200
            val focusable = true
            val popupWindow = PopupWindow(popUp, width, height, focusable)

            popupWindow.showAtLocation(greenbeltD, Gravity.CENTER, 0, 0)
        }
    }

    fun confirmChanges(v : View) {
        var allButton : RadioButton = popUp.findViewById(R.id.all)
        var directionsButton : RadioButton = popUp.findViewById(R.id.directions)
        var avgButton : RadioButton = popUp.findViewById(R.id.averageTimes)
        var noneButton : RadioButton = popUp.findViewById(R.id.none)

        if (directionsButton.isChecked) {
            averageText = false
            directionsText = true
        } else if (avgButton.isChecked) {
            averageText = true
            directionsText = false
        } else if (noneButton.isChecked) {
            averageText = false
            directionsText = false
        } else if (allButton.isChecked) {
            averageText = true
            directionsText = true
        }

        var intent = Intent(this, ResultsActivity::class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun destinationBack(v : View) {
        finishAfterTransition()
    }

    inner class AdLoad : InterstitialAdLoadCallback( ) {
        override fun onAdFailedToLoad(p0: LoadAdError) {
            super.onAdFailedToLoad(p0)
        }

        override fun onAdLoaded(p0: InterstitialAd) {
            super.onAdLoaded(p0)
            ad = p0
            ad!!.show(this@DestinationActivity)
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
        lateinit var destination : String
        var directionsText : Boolean = true
        var averageText : Boolean = true
    }
}