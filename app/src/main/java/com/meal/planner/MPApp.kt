package com.meal.planner

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import com.meal.core.constants.Constants
import com.meal.core.constants.StringConstants
import com.meal.network.di.networkModule
import com.meal.planner.di.appModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MPApp: Application() {

    private val networkFlipperPlugin: NetworkFlipperPlugin by inject()
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        StringConstants.createSpanishMap()
        StringConstants.createArficanMap()
        StringConstants.createVietnameseMap()
        startKoin{
            androidLogger()
            androidContext(this@MPApp)
            modules(appModule, networkModule)
        }

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.addPlugin(networkFlipperPlugin)
            client.start()
        }


    }
}