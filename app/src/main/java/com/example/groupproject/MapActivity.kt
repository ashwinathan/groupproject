package com.example.groupproject

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.LatLngBounds




class MapActivity : AppCompatActivity(), OnMapReadyCallback {


    private lateinit var mMap: GoogleMap


    private val locations = mapOf(
        "College Park U of MD" to LatLng(38.9784, -76.9283),
        "Greenbelt" to LatLng(38.9784, -76.9283),
        "Hyattsville Crossing" to LatLng(38.9651, -76.9564),
        "West Hyattsville" to LatLng(38.9555, -76.9693),
        "Fort Totten" to LatLng(38.9518, -77.0022),
        "Georgia Ave-Petworth" to LatLng(38.9369, -77.0238),
        "Columbia Heights" to LatLng(38.9289, -77.0324),
        "U St" to LatLng(38.9169, -77.0292),
        "Shaw-Howard U" to LatLng(38.9129, -77.0222 ),
        "Mt Vernon Sq" to LatLng(38.9053, -77.0223),
        "Gallery Place" to LatLng(38.8994, -77.0210),
        "Judiciary Sq" to LatLng(38.8961, -77.0166),
        "Union Station" to LatLng(38.8978, -77.0071),
        "NoMa-Gallaudet U" to LatLng(38.9066, -77.0034),
        "Rhode Island Ave" to LatLng(38.9207, -76.9960),
        "Brookland-CUA" to LatLng(38.9332, -76.9945)




        // ... (other locations)
    )




    private var collegeParklatlng = LatLng(38.9784, -76.9283)
    private var greenbeltLatLng = LatLng(39.0109, -76.9113)
    private var hyattsvillecrossingLatLng = LatLng(38.9651, -76.9564);
    private var westhyattsvilleLatLng = LatLng(38.9555, -76.9693);
    private var forttottenLatLng = LatLng(38.9518, -77.0022);
    private var georgiaavepetworthLatLng = LatLng(38.9369, -77.0238);
    private var columbiaheightsLng = LatLng(38.9289, -77.0324);
    private var ustLng = LatLng(38.9169, -77.0292);
    private var shawhowardULatLng = LatLng(38.9129, -77.0222 );
    private var mtvernonsqLatLng = LatLng(38.9053, -77.0223);
    private var galleryplaceLatLng = LatLng(38.8994, -77.0210);
    private var judiciarysqLatLng = LatLng(38.8961, -77.0166);
    private var unionstationLatLng =  LatLng(38.8978, -77.0071);
    private var nomagallaudetuLatLng = LatLng(38.9066, -77.0034);
    private var rhodeislandaveLatLng = LatLng(38.9207, -76.9960);
    private var brooklandcuaLatLng = LatLng(38.9332, -76.9945);


    private var currentLocationLatLng: LatLng? = null
    private var currentDestinationLatLng: LatLng? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


         //Example of setting locations based on some external logic
        currentLocationLatLng = locations[MainActivity.trains.getLocation()]
        currentDestinationLatLng = locations[MainActivity.trains.getDestination()]


//        currentLocationLatLng = LatLng(38.9784, -76.9283)
//        currentDestinationLatLng = LatLng(38.9332, -76.9945)
        Log.w("CMSC", "" + currentLocationLatLng);
        Log.w("CMSC", "" + currentDestinationLatLng)


    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        fun getLocationNameByLatLng(latlng: LatLng): String? {
            return locations.entries.firstOrNull { it.value == latlng }?.key
        }




        currentLocationLatLng?.let { location ->
            val locationName = getLocationNameByLatLng(location) ?: "Current Location"
            mMap.addMarker(MarkerOptions().position(location).title(locationName))
        }


        currentDestinationLatLng?.let { destination ->
            val destinationName = getLocationNameByLatLng(destination) ?: "Destination"
            mMap.addMarker(MarkerOptions().position(destination).title(destinationName))
        }




        if (currentLocationLatLng != null && currentDestinationLatLng != null) {
            mMap.addPolyline(
                PolylineOptions()
                    .add(currentLocationLatLng, currentDestinationLatLng)
                    .width(5f)
                    .color(Color.RED)
            )
        }




//        currentLocationLatLng?.let { location ->
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
//        }


        val builder = LatLngBounds.Builder()


        // Include non-null LatLng objects
        currentLocationLatLng?.let { builder.include(it) }
        currentDestinationLatLng?.let { builder.include(it) }


        // Check if both locations are not null before moving the camera
        if (currentLocationLatLng != null && currentDestinationLatLng != null) {
            val bounds = builder.build()
            val padding = 100 // offset from edges of the map in pixels
            val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)


            // Move the camera to fit the bounds
            mMap.animateCamera(cameraUpdate)
        }


    }

    fun mapBack(v: View) {
        finishAfterTransition()
    }
}





