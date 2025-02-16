// ContactsActivity.kt
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
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContactActivity : AppCompatActivity() {

    private lateinit var textViewUserName: TextView
    private lateinit var editTextSearch: EditText
    private lateinit var recyclerViewContacts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Top bar & search
        textViewUserName = findViewById(R.id.textViewUserName)
        editTextSearch = findViewById(R.id.editTextSearch)

        // Bottom nav
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        // RecyclerView
        recyclerViewContacts = findViewById(R.id.recyclerViewContacts)
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        // 1. Prepare data
        val contactItems = mutableListOf<ContactListItem>()

        // Section header: In Contacts
        contactItems.add(ContactListItem.SectionHeader("In Contacts"))
        contactItems.add(ContactListItem.Contact("Henry School", R.drawable.google, true))
        contactItems.add(ContactListItem.Contact("Emily James", R.drawable.google, true))
        contactItems.add(ContactListItem.Contact("Lily Thomas", R.drawable.google, true))

        // Section header: Invite New Friends
        contactItems.add(ContactListItem.SectionHeader("Invite New Friends"))
        contactItems.add(ContactListItem.Contact("Amy Wesley", R.drawable.apple, false))
        contactItems.add(ContactListItem.Contact("Laura Ryan", R.drawable.apple, false))
        contactItems.add(ContactListItem.Contact("Christopher", R.drawable.apple, false))

        // 2. Set up adapter
        val adapter = ContactsAdapter(contactItems)
        recyclerViewContacts.adapter = adapter

        // 3. Bottom Nav Clicks
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    true
                }
                R.id.nav_add -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.nav_contacts ->
                    true

                else -> false
            }
        }

        // 4. (Optional) Search Functionality
        // You could add a text watcher to filter the list in real time, e.g.:
        // editTextSearch.addTextChangedListener { query ->
        //     // Filter contactItems by query, update adapter
        // }
    }
}
