package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DmsActivity : AppCompatActivity() {

    private lateinit var textViewUserName: TextView
    private lateinit var textViewRequests: TextView
    private lateinit var editTextSearch: EditText
    private lateinit var recyclerViewContacts: RecyclerView

    private lateinit var adapter: DmContactAdapter
    private lateinit var buttonBack: ImageButton

    // Sample data
    private val dmList = mutableListOf(
        DmContact("Henry Benjamin", R.drawable.henrybenjamin),
        DmContact("Emily James", R.drawable.emily),
        DmContact("Lily Thomas", R.drawable.lily),
        DmContact("Christopher", R.drawable.christopher),
        DmContact("Amy Wesley", R.drawable.amy),
        DmContact("Laura Ryan", R.drawable.laura)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dms) // or activity_dms if that's your file name

        // Top bar & search references
        textViewUserName = findViewById(R.id.textViewUserName)
        textViewRequests = findViewById(R.id.textViewRequests)
        editTextSearch = findViewById(R.id.editTextSearchDm)
        buttonBack = findViewById(R.id.buttonBack)

        // Set user name (if dynamic)
        textViewUserName.text = "OliviaD"

        // RecyclerView setup
        recyclerViewContacts = findViewById(R.id.recyclerViewDms)
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        // Adapter with two callbacks
        adapter = DmContactAdapter(
            dmList,
            onCameraClick = { contact ->
                // Camera icon clicked
                Toast.makeText(this, "Camera for ${contact.name}", Toast.LENGTH_SHORT).show()
                // Or start a video call, etc.
            },
            onContactClick = { contact ->
                // Row clicked -> open chat
                openChat(contact)
            }
        )

        recyclerViewContacts.adapter = adapter

        // Optional: handle "Requests" click
        textViewRequests.setOnClickListener {
            Toast.makeText(this, "Requests clicked", Toast.LENGTH_SHORT).show()
        }

        buttonBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }



    private fun openChat(contact: DmContact) {
        // Start ChatActivity, passing the contact name, avatar, or ID
        val intent = Intent(this, ChatActivity::class.java)
        intent.putExtra("contact_name", contact.name)
        // If you want to pass avatarRes or an ID, do so here
        startActivity(intent)
    }
}
