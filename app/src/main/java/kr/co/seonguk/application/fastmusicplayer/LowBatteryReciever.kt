package kr.co.seonguk.application.fastmusicplayer

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LowBatteryReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        when(intent.action){
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "배터리가 부족하다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}