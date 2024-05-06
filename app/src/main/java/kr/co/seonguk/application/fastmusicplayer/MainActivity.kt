package kr.co.seonguk.application.fastmusicplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.seonguk.application.fastmusicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingEvent()
    }


    private fun settingEvent(){
        binding.apply {
            buttonPlay.setOnClickListener {
                mediaPlayerPlay()
            }

            buttonStop.setOnClickListener {
                mediaPlayerStop()
            }

            buttonPause.setOnClickListener {
                mediaPlayerPause()
            }
        }
    }

    private fun mediaPlayerPlay(){

        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_PLAY
        }
        startService(intent)
    }

    private fun mediaPlayerPause(){
        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_PAUSE
        }
        startService(intent)
    }

    private fun mediaPlayerStop(){
        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_STOP
        }
        startService(intent)
    }
}












