package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CallActivity : AppCompatActivity() {

    private lateinit var textViewCallerName: TextView
    private lateinit var imageViewCallerAvatar: ImageView
    private lateinit var textViewCallTime: TextView

    private lateinit var buttonSpeaker: ImageButton
    private lateinit var buttonMute: ImageButton
    private lateinit var buttonVideo: ImageButton
    private lateinit var buttonmenu: ImageButton
    private lateinit var buttonEndCall: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        // Bind UI elements
        textViewCallerName = findViewById(R.id.textViewCallerName)
        imageViewCallerAvatar = findViewById(R.id.imageViewCallerAvatar)
        textViewCallTime = findViewById(R.id.textViewCallTime)

        buttonSpeaker = findViewById(R.id.buttonSpeaker)
        buttonMute = findViewById(R.id.buttonMute)
        buttonVideo = findViewById(R.id.buttonVideo)
        buttonmenu = findViewById(R.id.buttonMore)
        buttonEndCall = findViewById(R.id.buttonEndCall)

        // Set up dummy data
        textViewCallerName.text = "Henry Benjamin"
        textViewCallTime.text = "10:32"  // e.g., call duration or current time

        // Button click listeners
        buttonSpeaker.setOnClickListener {
            Toast.makeText(this, "Speaker toggled", Toast.LENGTH_SHORT).show()
        }

        buttonMute.setOnClickListener {
            Toast.makeText(this, "Mic muted/unmuted", Toast.LENGTH_SHORT).show()
        }

        buttonVideo.setOnClickListener {
            Toast.makeText(this, "Video toggled", Toast.LENGTH_SHORT).show()
        }

        buttonmenu.setOnClickListener {
            Toast.makeText(this, "Menu", Toast.LENGTH_SHORT).show()
        }

        buttonEndCall.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }
    }
}
