package com.ebac.jokenpo

import android.util.Log
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import androidx.lifecycle.*

class CustomObserver: DefaultLifecycleObserver, LifecycleEventObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("Lifecycle", "Observer ${owner.toString()} - onResume")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("Lifecycle", "Observer ${source.toString()} event: ${event.toString()}")
    }
}