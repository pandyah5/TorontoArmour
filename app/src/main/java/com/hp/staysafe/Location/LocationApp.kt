package com.hp.staysafe.Location

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class LocationApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // For showing that the location is being tracked
            val updateChannel = NotificationChannel(
                "locationUpdates",
                "Location updates",
                NotificationManager.IMPORTANCE_LOW
            )

            // For issuing alerts that the user is in an unsafe location
            val alertChannel = NotificationChannel(
                "safetyAlert",
                "Safety Alert",
                NotificationManager.IMPORTANCE_HIGH
            )


            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(updateChannel)
            notificationManager.createNotificationChannel(alertChannel)
        }
    }
}