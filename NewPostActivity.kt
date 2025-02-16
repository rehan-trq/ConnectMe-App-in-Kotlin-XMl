package com.RehanTariq.i220965
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewPostActivity : AppCompatActivity() {

    private lateinit var ivBack: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvNext: TextView
    private lateinit var ivSelectedImage: ImageView
    private lateinit var ivCamera: ImageView
    private lateinit var rvImages: RecyclerView

    // Sample data for the grid
    private val sampleImages = listOf(
        GalleryImage(R.drawable.image1),
        GalleryImage(R.drawable.image2),
        GalleryImage(R.drawable.image3),
        GalleryImage(R.drawable.image5),
        GalleryImage(R.drawable.image6),
        GalleryImage(R.drawable.image7),
        GalleryImage(R.drawable.image8),
        GalleryImage(R.drawable.image9),
        GalleryImage(R.drawable.image10),
        GalleryImage(R.drawable.image11),
        GalleryImage(R.drawable.image12),
        GalleryImage(R.drawable.image13),
        // ... add as many as you want
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        // Bind UI elements
        ivBack = findViewById(R.id.ivBack)
        tvTitle = findViewById(R.id.tvTitle)
        tvNext = findViewById(R.id.tvNext)
        ivSelectedImage = findViewById(R.id.ivSelectedImage)
        ivCamera = findViewById(R.id.ivCamera)
        rvImages = findViewById(R.id.rvImages)

        // Set up RecyclerView
        rvImages.layoutManager = GridLayoutManager(this, 4) // 4 columns
        val adapter = ImageAdapter(sampleImages) { selected ->
            // When user clicks a thumbnail, show it in the main preview
            ivSelectedImage.setImageResource(selected.resourceId)
        }
        rvImages.adapter = adapter

        // Default: set first image as preview
        if (sampleImages.isNotEmpty()) {
            ivSelectedImage.setImageResource(sampleImages[0].resourceId)
        }

        // Handle top bar interactions
        ivBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        tvNext.setOnClickListener {
            // Move to next step (e.g., caption screen)
            Toast.makeText(this, "Next clicked!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PostActivity::class.java))
        }

        // Camera icon
        ivCamera.setOnClickListener {
            Toast.makeText(this, "Open camera", Toast.LENGTH_SHORT).show()
            // TODO: Implement camera functionality
            startActivity(Intent(this, CameraPostActivity::class.java))
        }
    }
}
