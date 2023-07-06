package com.example.bidfeed.utils

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import io.realm.Realm
import io.realm.RealmConfiguration


class SurvayApplication : Application() {
    companion object {
        private lateinit var appContext: Context
        fun getCtx(): Context {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext;
        init()
    }


    private fun init(){
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("HBL_Survey.realm").schemaVersion(1).deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }

}