package com.example.daneko.androidadventcalendar.kotlin

import com.example.daneko.androidadventcalendar.kotlin.a.Sample
import timber.log.Timber


class SampleKotlin {
    fun method() {
        Sample().sampleMethod {
            Timber.v("call")
        }
    }
}

