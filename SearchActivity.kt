package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    private lateinit var editTextSearch: EditText
    private lateinit var buttonSearchIcon: ImageButton
    private lateinit var recyclerViewRecentSearches: RecyclerView

    // Our adapter and in-memory list of recent searches
    private lateinit var adapter: RecentSearchAdapter
    private var recentSearches: MutableList<SearchItem> = mutableListOf(
        SearchItem("Henry Benjamin"),
        SearchItem("Emily James"),
        SearchItem("Lily Thomas")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // 1. Find views by ID
        editTextSearch = findViewById(R.id.editTextSearch)
        buttonSearchIcon = findViewById(R.id.buttonSearchIcon)
        recyclerViewRecentSearches = findViewById(R.id.recyclerViewRecentSearches)

        // 2. Set up the RecyclerView
        recyclerViewRecentSearches.layoutManager = LinearLayoutManager(this)
        adapter = RecentSearchAdapter(recentSearches)
        recyclerViewRecentSearches.adapter = adapter

        // 3. (Optional) Handle the search icon click
        buttonSearchIcon.setOnClickListener {
            val query = editTextSearch.text.toString().trim()
            if (!TextUtils.isEmpty(query)) {
                // Add new query to the top of recent searches
                recentSearches.add(0, SearchItem(query))
                adapter.notifyItemInserted(0)
                // Scroll to show the newly added item
                recyclerViewRecentSearches.scrollToPosition(0)
                // Clear the search field or leave it - your choice
                // editTextSearch.text.clear()
            }
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_search -> {
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
                R.id.nav_contacts -> {

                    startActivity(Intent(this, ContactActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
