package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VideoCallActivity : AppCompatActivity() {

    private lateinit var tvCallerName: TextView
    private lateinit var tvCallTime: TextView
    private lateinit var localVideoPreview: FrameLayout

    private lateinit var buttonMore: ImageButton
    private lateinit var buttonVideo: ImageButton
    private lateinit var buttonSpeaker: ImageButton
    private lateinit var buttonMute: ImageButton
    private lateinit var buttonEndCall: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        // Bind UI elements
        tvCallerName = findViewById<TextView>(R.id.tvCallerName)
        tvCallTime = findViewById<TextView>(R.id.tvCallTime)
        localVideoPreview = findViewById<FrameLayout>(R.id.localVideoPreview)

        buttonMore = findViewById<ImageButton>(R.id.buttonMore)
        buttonVideo = findViewById<ImageButton>(R.id.buttonVideo)
        buttonSpeaker = findViewById<ImageButton>(R.id.buttonSpeaker)
        buttonMute = findViewById<ImageButton>(R.id.buttonMute)
        buttonEndCall = findViewById<ImageButton>(R.id.buttonEndCall)

        // Example data
        tvCallerName.text = "Henry Benjamin"
        tvCallTime.text = "10:32"

        // Button click listeners
        buttonMore.setOnClickListener {
            Toast.makeText(this, "More options", Toast.LENGTH_SHORT).show()
        }

        buttonVideo.setOnClickListener {
            Toast.makeText(this, "Toggle video", Toast.LENGTH_SHORT).show()
            // TODO: Toggle local camera feed, etc.
        }

        buttonSpeaker.setOnClickListener {
            Toast.makeText(this, "Toggle speaker", Toast.LENGTH_SHORT).show()
            // TODO: Switch audio to speaker or earpiece
        }

        buttonMute.setOnClickListener {
            Toast.makeText(this, "Toggle mute", Toast.LENGTH_SHORT).show()
            // TODO: Mute/unmute microphone
        }

        buttonEndCall.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }
}
