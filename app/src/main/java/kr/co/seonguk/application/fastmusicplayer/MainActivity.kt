package kr.co.seonguk.application.fastmusicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.seonguk.application.fastmusicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var mediaPlayer : MediaPlayer? = null

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
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.music_my).apply {
                isLooping = true
            }
            mediaPlayer?.start()
        }
    }

    private fun mediaPlayerPause(){
        mediaPlayer?.pause()
    }

    private fun mediaPlayerStop(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}












