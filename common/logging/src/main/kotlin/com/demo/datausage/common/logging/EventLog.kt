
package com.demo.datausage.common.logging

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import timber.log.Timber

private const val EVENT_LOG_INTENT_ACTION="EventLogIntentAction"
private const val EVENT_LOG_EXTRA_MESSAGE = "EventLogMessage"
interface EventLogReceiver{
    fun register()
    fun unregister()
}
@Suppress("DEPRECATION")
class EventLogReceiver_Impl(
    val context: Context
):EventLogReceiver{

    private val broadcast = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            intent?.also {
                val message=it.getStringExtra(EVENT_LOG_EXTRA_MESSAGE)
                message?.let{ logMessage->
                    Timber.d(logMessage)
                }
            }
        }
    }
    override fun register() {
        LocalBroadcastManager.getInstance(context).registerReceiver(
            broadcast,
            IntentFilter(EVENT_LOG_INTENT_ACTION)
        )
    }

    override fun unregister() {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcast)
    }

}