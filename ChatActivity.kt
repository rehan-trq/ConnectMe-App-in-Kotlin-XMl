package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class ChatActivity : AppCompatActivity() {

    private lateinit var textViewContactName: TextView
    private lateinit var buttonCall: ImageButton
    private lateinit var buttonVideoCall: ImageButton
    private lateinit var buttonViewProfile: Button
    private lateinit var imageViewAvatar: ImageView
    private lateinit var recyclerViewChat: androidx.recyclerview.widget.RecyclerView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: ImageButton

    private lateinit var adapter: ChatAdapter
    private val messages = mutableListOf<ChatMessage>()

    private var vanishModeEnabled = false
    private lateinit var vanishModeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        // Init UI elements
        textViewContactName = findViewById(R.id.textViewContactName)
        buttonCall = findViewById(R.id.buttonCall)
        buttonViewProfile = findViewById(R.id.buttonViewProfile)
        imageViewAvatar = findViewById(R.id.imageViewAvatar)
        recyclerViewChat = findViewById(R.id.recyclerViewChat)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSend = findViewById(R.id.buttonSend)
        buttonVideoCall = findViewById(R.id.buttonVideoCall)

        // Vanish mode switch and text
        val switchVanishMode = findViewById<Switch>(R.id.switchVanishMode)
        vanishModeText = findViewById(R.id.switchVanishMode)

        // Sample contact name & avatar
        textViewContactName.text = "Henry Benjamin"
        imageViewAvatar.setImageResource(R.drawable.henrybenjamin)

        // Sample chat messages
        messages.add(ChatMessage("Hello, How are you?", "10:30", true))
        messages.add(ChatMessage("Hi, I am great, Wbu?", "10:32", false))
        messages.add(ChatMessage("I am doing well", "01:30", true))
        messages.add(ChatMessage("Good to know", "01:30", false))

        // Setup RecyclerView
        adapter = ChatAdapter(messages)
        recyclerViewChat.layoutManager = LinearLayoutManager(this)
        recyclerViewChat.adapter = adapter

        // Back button
        val backButton = findViewById<ImageButton>(R.id.buttonBack)
        backButton.setOnClickListener {
            startActivity(Intent(this, DmsActivity::class.java))
        }

        // Handle "Send" button
        buttonSend.setOnClickListener {
            val text = editTextMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                // Create and add new outgoing message
                val newMessage = ChatMessage(text, "01:40", false)
                messages.add(newMessage)
                adapter.notifyItemInserted(messages.size - 1)
                recyclerViewChat.scrollToPosition(messages.size - 1)
                editTextMessage.text.clear()

                // If vanish mode is enabled, schedule removal
                if (vanishModeEnabled) {
                    // 5 seconds for testing; use 24 hours = 86400000 ms in production
                    removeMessageAfterTime(newMessage, 5000)
                }
            }
        }

        // Handle "View Profile"
        buttonViewProfile.setOnClickListener {
            Toast.makeText(this, "View Profile clicked", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to profile screen
        }

        // Handle "Call" icon
        buttonCall.setOnClickListener {
            startActivity(Intent(this, CallActivity::class.java))
        }

        // Handle "Video Call" icon
        buttonVideoCall.setOnClickListener {
            startActivity(Intent(this, VideoCallActivity::class.java))
        }

        // Toggle vanish mode
        switchVanishMode.setOnCheckedChangeListener { _, isChecked ->
            vanishModeEnabled = isChecked
            if (isChecked) {
                vanishModeText.visibility = View.VISIBLE
            }

            else {
                vanishModeText.visibility = View.VISIBLE
            }
        }
    }

    /**
     * Removes the specified [chatMessage] from the list after [delayMillis].
     */
    private fun removeMessageAfterTime(chatMessage: ChatMessage, delayMillis: Long) {
        Handler(Looper.getMainLooper()).postDelayed({
            messages.remove(chatMessage)
            adapter.notifyDataSetChanged()
        }, delayMillis)
    }
}
