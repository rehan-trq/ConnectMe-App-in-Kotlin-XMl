package com.RehanTariq.i220965
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var profilePostsAdapter: ProfilePostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Top bar
        val ivEditProfile = findViewById<ImageView>(R.id.ivEditProfile)
        ivEditProfile.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }

        // Populate user data (could come from a ViewModel, network, etc.)
        val tvProfileName = findViewById<TextView>(R.id.tvProfileName)
        val tvProfileBio = findViewById<TextView>(R.id.tvProfileBio)
        val tvFollowersCount = findViewById<TextView>(R.id.tvFollowersCount)
        val tvFollowingCount = findViewById<TextView>(R.id.tvFollowingCount)
        tvProfileName.text = "Olivia Daniel"
        tvProfileBio.text = "two bananas for a pound, three bananas for a euro"

        // Sample images for the grid
        val sampleImages = listOf(
            PostImage(R.drawable.google),
            PostImage(R.drawable.google),
            PostImage(R.drawable.google),
            PostImage(R.drawable.google),
            PostImage(R.drawable.google),
            PostImage(R.drawable.google),
        )
        val rvProfilePosts = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvProfilePosts)
        // RecyclerView setup
        profilePostsAdapter = ProfilePostsAdapter(sampleImages)
        rvProfilePosts.layoutManager = GridLayoutManager(this, 3)
        rvProfilePosts.adapter = profilePostsAdapter

        // Follower list
        tvFollowersCount.setOnClickListener {
            startActivity(Intent(this, FollowersActivity::class.java))
        }

        tvFollowingCount.setOnClickListener {
            startActivity(Intent(this, FollowingActivity::class.java))
        }


        // Bottom navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
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
