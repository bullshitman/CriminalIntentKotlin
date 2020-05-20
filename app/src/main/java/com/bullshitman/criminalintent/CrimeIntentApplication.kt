package com.bullshitman.criminalintent

import android.app.Application

class CrimeIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}