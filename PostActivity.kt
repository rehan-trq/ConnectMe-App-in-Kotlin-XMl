package com.RehanTariq.i220965

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PostActivity : AppCompatActivity() {

    private lateinit var ivMainImage: ImageView
    private lateinit var ivSecondImage: ImageView
    private lateinit var etCaption: EditText
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        // Bind views
        ivMainImage = findViewById(R.id.ivMainImage)
        ivSecondImage = findViewById(R.id.ivSecondImage)
        etCaption = findViewById(R.id.etCaption)
        btnShare = findViewById(R.id.btnShare)
        var backbtn = findViewById<ImageView>(R.id.ivClose)

        backbtn.setOnClickListener {
            startActivity(Intent(this, NewPostActivity::class.java))
        }
        // Handle "Share" click
        btnShare.setOnClickListener {
            val captionText = etCaption.text.toString().trim()
            // For now, just show a Toast
            Toast.makeText(
                this,
                "Sharing post with caption: $captionText",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(Intent(this, HomeActivity::class.java))
        }

        // Optionally handle clicks on images if you want to swap them or pick new images
        ivMainImage.setOnClickListener {
            Toast.makeText(this, "Main image clicked", Toast.LENGTH_SHORT).show()
            // TODO: Open image picker or handle new image selection
        }

        ivSecondImage.setOnClickListener {
            Toast.makeText(this, "Second image clicked", Toast.LENGTH_SHORT).show()
            // TODO: Open image picker or handle new image selection
        }
    }
}
