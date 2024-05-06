package kr.co.seonguk.application.fastmusicplayer

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.IBinder

class MediaPlayerService : Service() {

    private var mediaPlayer:MediaPlayer? = null
    private val receiver = LowBatteryReciever()


    override fun onCreate() {
        super.onCreate()

        initReceiver()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            MEDIA_PLAYER_PLAY -> {
                if (mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(baseContext, R.raw.music_my)
                }
                mediaPlayer?.start()
            }

            MEDIA_PLAYER_PAUSE -> {
                mediaPlayer?.pause()
            }

            MEDIA_PLAYER_STOP -> {
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null
                stopSelf()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun initReceiver(){
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_BATTERY_LOW)
        }

        registerReceiver(receiver, intentFilter)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}