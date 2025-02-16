package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val storyRecyclerView = findViewById<RecyclerView>(R.id.storyRecyclerView)
        val postRecyclerView = findViewById<RecyclerView>(R.id.postRecyclerView)
        val buttonDM = findViewById<ImageButton>(R.id.buttonDM)

        // Sample data for Stories
        val storyList = listOf(
            Story(R.drawable.story1),
            Story(R.drawable.story2),
            Story(R.drawable.story3),
            Story(R.drawable.story4),
        )

        // Sample data for Posts
        val postList = listOf(
            Post(R.drawable.emily1, "User1", R.drawable.emily1, "Emily James Had a great hike across this beautiful \n" +
                    "landscape "),
            Post(R.drawable.emily1, "User2", R.drawable.emily1, "Another amazing post!")
        )

        // Setup Story RecyclerView
        storyRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyRecyclerView.adapter = StoryAdapter(storyList)

        // Setup Post RecyclerView
        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.adapter = PostAdapter(postList)

        buttonDM.setOnClickListener {
            startActivity(Intent(this, DmsActivity::class.java))
        }


        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
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
                R.id.nav_contacts -> {

                    startActivity(Intent(this, ContactActivity::class.java))
                    true
                }
                R.id.nav_home -> true
                else -> false
            }
        }
    }
}