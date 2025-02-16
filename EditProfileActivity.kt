package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var ivProfilePic: ImageView
    private lateinit var tvDone: TextView

    private lateinit var etName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etContactNumber: EditText
    private lateinit var etBio: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Bind UI elements
        ivProfilePic = findViewById(R.id.ivProfilePic)
        tvDone = findViewById(R.id.tvDone)
        etName = findViewById(R.id.etName)
        etUsername = findViewById(R.id.etUsername)
        etContactNumber = findViewById(R.id.etContactNumber)
        etBio = findViewById(R.id.etBio)

        // Example: Pre-fill with existing data (could come from a ViewModel or database)
        etName.setText("Olivia Daniel")
        etUsername.setText("OliviaD")
        etContactNumber.setText("+42 7412 5443058")
        etBio.setText("Just an average 14 year old")

        // Handle "Done" click
        tvDone.setOnClickListener {
            // Collect edited values
            val updatedName = etName.text.toString().trim()
            val updatedUsername = etUsername.text.toString().trim()
            val updatedContactNumber = etContactNumber.text.toString().trim()
            val updatedBio = etBio.text.toString().trim()

            // TODO: Save or update these values in your database or backend
            // For now, just show a Toast
            Toast.makeText(
                this,
                "Profile Updated:\nName: $updatedName\nUsername: $updatedUsername\nContact: $updatedContactNumber\nBio: $updatedBio",
                Toast.LENGTH_LONG
            ).show()

            // Close activity or navigate back
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        // Optionally, allow changing the profile picture on click
        ivProfilePic.setOnClickListener {
            Toast.makeText(this, "Change Profile Picture clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement logic to pick image from gallery or take a photo
        }
    }
}
