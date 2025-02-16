package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.RehanTariq.i220965.Follower

class FollowingActivity : AppCompatActivity() {

    private lateinit var tvUserName: TextView
    private lateinit var tvFollowers: TextView
    private lateinit var tvFollowing: TextView
    private lateinit var etSearch: EditText
    private lateinit var ivSearchIcon: ImageView
    private lateinit var rvUserList: RecyclerView

    // Example data
    private val userData = listOf(
        Follower("Olympia Gassert", R.drawable.olympia),
        Follower("Carmel Humenik", R.drawable.carmel),
        Follower("Tony Penberthy", R.drawable.tony),
        Follower("Heathcliff Boward", R.drawable.heathcliff),
        Follower("Fanni Medawar", R.drawable.fanni),
        Follower("Ava Bennin", R.drawable.ava),
        Follower("Tina Ayola", R.drawable.tina),
        Follower("Stern Saulo", R.drawable.stern),
        Follower("Meggie Bussler", R.drawable.meggie),
        Follower("Carmelina Boshard", R.drawable.carmelina),
        Follower("Shaylyn Babbs", R.drawable.shaylyn),
        Follower("Delbert Pownell", R.drawable.delbert)
        // ... more if you like
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_following)

        tvUserName = findViewById(R.id.tvUserName)
        tvFollowers = findViewById(R.id.tvFollowers)
        tvFollowing = findViewById(R.id.tvFollowing)
        etSearch = findViewById(R.id.etSearch)
        ivSearchIcon = findViewById(R.id.ivSearchIcon)
        rvUserList = findViewById(R.id.rvPeopleList)
        var backbutton = findViewById<ImageView>(R.id.ivBack)

        // Set the top text
        tvUserName.text = "OliviaD"
        // "410 Followers" in black, "387 Following" in brown & bold (already in XML)

        // RecyclerView setup
        rvUserList.layoutManager = LinearLayoutManager(this)
        rvUserList.adapter = FollowersAdapter(userData) { user ->
            // Chat icon click
            Toast.makeText(this, "Chat with ${user.name}", Toast.LENGTH_SHORT).show()
            // TODO: Navigate to chat screen
        }

        tvFollowers.setOnClickListener {
            startActivity(Intent(this, FollowersActivity::class.java))
        }

        backbutton.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }


        // If you want to implement search:
        ivSearchIcon.setOnClickListener {
            val query = etSearch.text.toString().trim()
            Toast.makeText(this, "Search for: $query", Toast.LENGTH_SHORT).show()
            // TODO: Filter the userData if needed
        }
    }
}
