package com.example.groupproject

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity




class ResultsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.results)

        MainActivity.trains = Trains(MainActivity.location, DestinationActivity.destination)
        MainActivity.trains.setPreferences(this)

        if (DestinationActivity.directionsText) {
            if (MainActivity.trains.getLocation()=="Greenbelt") {
                greenbeltStart()
            } else if(MainActivity.trains.getLocation()=="College Park U of MD") {
                collegeparkStart()
            } else if (MainActivity.trains.getLocation()=="Hyattsville Crossing") {
                hyattsvilleStart()
            } else if (MainActivity.trains.getLocation()=="West Hyattsville") {
                westhyattsvilleStart()
            } else if (MainActivity.trains.getLocation()=="Fort Totten") {
                fortStart()
            } else if (MainActivity.trains.getLocation()=="Georgia Ave-Petworth") {
                georgiaStart()
            } else if (MainActivity.trains.getLocation()=="Columbia Heights") {
                columbiaStart()
            } else if (MainActivity.trains.getLocation()=="U St") {
                ustStart()
            } else if (MainActivity.trains.getLocation()=="Shaw-Howard U") {
                howardStart()
            } else if (MainActivity.trains.getLocation()=="Mt Vernon Sq") {
                vernonStart()
            } else if (MainActivity.trains.getLocation()=="Gallery Place") {
                galleryStart()
            } else if (MainActivity.trains.getLocation()=="Judiciary Sq") {
                judiciaryStart()
            } else if (MainActivity.trains.getLocation()=="Union Station") {
                unionStart()
            } else if (MainActivity.trains.getLocation()=="NoMa-Gallaudet U") {
                nomaStart()
            } else if (MainActivity.trains.getLocation()=="Rhode Island Ave") {
                rhodeislandStart()
            } else if (MainActivity.trains.getLocation()=="Brookland-CUA") {
                brooklandStart()
            } else {
                Log.w("result", "throwing error:" + MainActivity.trains.getLocation())
            }
        }

        val timeDisplay: TextView = findViewById(R.id.timeDisplay)
        val analogClockView: AnalogClockView = findViewById(R.id.analogClockView)


        // Pass the TextView to AnalogClockView
        analogClockView.setTimeDisplay(timeDisplay)




        var results : TextView = findViewById(R.id.results)
        results.text= "To get from " + MainActivity.trains.getLocation() + " to " + MainActivity.trains.getDestination()

        var timeTrain: TextView= findViewById(R.id.timeBetweenTrains)

        if (DestinationActivity.averageText) {

            if (AnalogClockView.daytime) {
                timeTrain.text= "Daytime Average between trains: \nRed Line: 6min, Yellow Line: 8min, Green Line: 8min"
            } else {
                timeTrain.text= "Evening Average between trains: \nRed Line: 10min, Yellow Line: 12min, Green Line: 14min"
            }
        }

    }


    fun greenbeltStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 9 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 10 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun collegeparkStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 9 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun hyattsvilleStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun westhyattsvilleStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOPS " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOPS " +
                    "then get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun fortStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun georgiaStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP " +
                    "then get on Red Line towards Shady Grove for 5 STOPS"
        }
    }


    fun columbiaStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS " +
                    "then get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 4 STOPS " +
                    "then get on Red Line towards Glenmont for 1 STOP"
        }
    }


    fun ustStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS " +
                    "then get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Glenmont for 2 STOP"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 3 STOPS " +
                    "then get on Red Line towards Glenmont for 1 STOP"
        }
    }


    fun howardStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS " +
                    "then get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Glenmont for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 2 STOPS " +
                    "then get on Red Line towards Glenmont for 1 STOP"
        }
    }


    fun vernonStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 9 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get On Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Glenmont for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Glenmont for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Green Line towards Branch Ave or Yellow Line towards Huntington for 1 STOP " +
                    "then get on Red Line towards Glenmont for 1 STOPS"
        }
    }


    fun galleryStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 10 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 9 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 8 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 7 STOPS"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 6 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get On Green Line towards Greenbelt or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Glenmont for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Glenmont for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP"
        }
    }


    fun judiciaryStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Red Line towards Glenmont for 5 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Red Line towards Glenmont for 5 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Red Line towards Glenmont for 5 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Red Line towards Glenmont for 5 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Red Line towards Glenmont for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP then get on Green Line towards Greenbelt" +
                    "or Yellow Line towards Greenbelt for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Glenmont for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="No Train to take"
        }
    }


    fun unionStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Red Line towards Glenmont for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Red Line towards Glenmont for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Red Line towards Glenmont for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Red Line towards Glenmont for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Red Line towards Glenmont for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get on Red Line towards Glenmont for 4 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        }
    }


    fun nomaStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Red Line towards Glenmont for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Red Line towards Glenmont for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Red Line towards Glenmont for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Red Line towards Glenmont for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Red Line towards Glenmont for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get on Red Line towards Glenmont for 3 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get on Red Line towards Glenmont for 3 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOPS"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS"
        }
    }


    fun rhodeislandStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Red Line towards Glenmont for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Red Line towards Glenmont for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Red Line towards Glenmont for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Red Line towards Glenmont for 2 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Red Line towards Glenmont for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get on Red Line towards Glenmont for 2 STOPS then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 4 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS"
        }
    }


    fun brooklandStart() {
        var trainsToTake : TextView = findViewById(R.id.trainList)
        if (MainActivity.trains.getDestination()=="Greenbelt") {
            trainsToTake.text="Get On Red Line towards Glenmont for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="College Park U of MD") {
            trainsToTake.text="Get On Red Line towards Glenmont for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Hyattsville Crossing") {
            trainsToTake.text="Get On Red Line towards Glenmont for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="West Hyattsville") {
            trainsToTake.text="Get On Red Line towards Glenmont for 1 STOP then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Fort Totten") {
            trainsToTake.text="Get On Red Line towards Glenmont for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Georgia Ave-Petworth") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Columbia Heights") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="U St") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Shaw-Howard U") {
            trainsToTake.text="Get on Red Line towards Glenmont for 1 STOP then get on Green Line towards Branch Ave " +
                    "or Yellow Line towards Huntington for 4 STOPS"
        } else if (MainActivity.trains.getDestination()=="Mt Vernon Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 5 STOPS then get on Green Line towards Greenbelt " +
                    "or Yellow Line towards Greenbelt for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="Gallery Place") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 5 STOPS"
        } else if (MainActivity.trains.getDestination()=="Brookland-CUA") {
            trainsToTake.text="No Train to take"
        } else if (MainActivity.trains.getDestination()=="Rhode Island Ave") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 1 STOP"
        } else if (MainActivity.trains.getDestination()=="NoMa-Gallaudet U") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 2 STOPS"
        } else if (MainActivity.trains.getDestination()=="Union Station") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 3 STOPS"
        } else if (MainActivity.trains.getDestination()=="Judiciary Sq") {
            trainsToTake.text="Get on Red Line towards Shady Grove for 4 STOPS"
        }
    }

    fun resultsSubmit(v: View) {
        var intent = Intent(this, MapActivity::class.java)
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
    }

    fun resultsBack(v : View) {
        finishAfterTransition()
    }



}









