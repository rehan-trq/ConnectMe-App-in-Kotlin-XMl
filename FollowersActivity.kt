package com.RehanTariq.i220965

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FollowersActivity : AppCompatActivity() {

    private lateinit var rvFollowers: RecyclerView
    private lateinit var tvUserName: TextView
    private lateinit var ivSearch: ImageView
    private lateinit var tvFollowersCount: TextView
    private lateinit var tvFollowingCount: TextView

    // Dummy data
    private val followersList = listOf(
        Follower("Alfredo Lipshutz", R.drawable.alfredo),
        Follower("Emily James", R.drawable.emily),
        Follower("Lily Thomas", R.drawable.lily),
        Follower("Christopher", R.drawable.christopher),
        Follower("Amy Wesley", R.drawable.amy),
        Follower("Laura Ryan", R.drawable.laura),
        Follower("Sandra Dady", R.drawable.sandra),
        Follower("Marigold Gomzales", R.drawable.marigold),
        Follower("Imojean Swigert", R.drawable.imojean),
        Follower("Aleck Epley", R.drawable.aleck),
        Follower("Rana Serandos", R.drawable.rana),
        Follower("Binky Vieyra", R.drawable.binky)
    )

    private var isShowingFollowers = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_followers)

        // Bind views
        rvFollowers = findViewById(R.id.rvPeopleList)
        tvUserName = findViewById(R.id.tvUserName)
        ivSearch = findViewById(R.id.ivSearchIcon)
        tvFollowersCount = findViewById(R.id.tvFollowers)
        tvFollowingCount = findViewById(R.id.tvFollowing)
        var ivBack = findViewById<ImageView>(R.id.ivBack)

        ivBack.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        tvUserName.text = "OliviaD"

        // RecyclerView setup
        rvFollowers.layoutManager = LinearLayoutManager(this)
        loadFollowers() // default

        // Search icon click
        ivSearch.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            // TODO: Open search or filter functionality
        }

        tvFollowingCount.setOnClickListener {
            startActivity(Intent(this, FollowingActivity::class.java))
        }

    }



    private fun loadFollowers() {
        isShowingFollowers = true
        val adapter = FollowersAdapter(followersList) { follower ->
            // Handle chat icon click
            Toast.makeText(this, "Chat with ${follower.name}", Toast.LENGTH_SHORT).show()
        }
        rvFollowers.adapter = adapter
    }

    private fun styleToggle(isFollowers: Boolean) {
        // If showing followers, make tvFollowersCount bold, tvFollowingCount normal
        if (isFollowers) {
            tvFollowersCount.setTypeface(null, Typeface.BOLD)
            tvFollowingCount.setTypeface(null, Typeface.NORMAL)
        } else {
            tvFollowersCount.setTypeface(null, Typeface.NORMAL)
            tvFollowingCount.setTypeface(null, Typeface.BOLD)
        }
    }
}
