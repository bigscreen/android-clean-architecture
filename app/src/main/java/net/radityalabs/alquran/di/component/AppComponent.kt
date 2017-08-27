package net.radityalabs.alquran.di.component

import android.content.Context
import net.radityalabs.alquran.App

interface AppComponent {
    fun appContext(): App?

    fun context(): Context
}