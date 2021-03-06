package com.fsck.k9.network

import java.util.concurrent.CopyOnWriteArraySet

internal abstract class ConnectivityManagerBase : ConnectivityManager {
    private val listeners = CopyOnWriteArraySet<ConnectivityChangeListener>()

    @Synchronized
    override fun addListener(listener: ConnectivityChangeListener) {
        listeners.add(listener)
    }

    @Synchronized
    override fun removeListener(listener: ConnectivityChangeListener) {
        listeners.remove(listener)
    }

    @Synchronized
    protected fun notifyListeners() {
        for (listener in listeners) {
            listener.onConnectivityChanged()
        }
    }
}
