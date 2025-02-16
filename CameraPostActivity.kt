package com.RehanTariq.i220965
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CameraPostActivity : AppCompatActivity() {

    private lateinit var ivClose: ImageView
    private lateinit var tvNext: TextView
    private lateinit var btnCapture: ImageButton
    private lateinit var tvPost: TextView
    private lateinit var tvStory: TextView
    private lateinit var ivRotate: ImageView
    private lateinit var ivThumbnail: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_post)

        // Bind UI elements
        ivClose = findViewById(R.id.ivClose)
        tvNext = findViewById(R.id.tvNext)
        btnCapture = findViewById(R.id.btnCapture)
        tvPost = findViewById(R.id.tvPost)
        tvStory = findViewById(R.id.tvStory)
        ivRotate = findViewById(R.id.ivRotate)
        ivThumbnail = findViewById(R.id.ivThumbnail)

        // Close button
        ivClose.setOnClickListener {
            startActivity(Intent(this, NewPostActivity::class.java))
        }

        // Next text
        tvNext.setOnClickListener {
            Toast.makeText(this, "Next clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, PostActivity::class.java))
        }

        // Capture button
        btnCapture.setOnClickListener {
            Toast.makeText(this, "Capture photo", Toast.LENGTH_SHORT).show()
            // TODO: Trigger camera capture
        }

        // Rotate camera
        ivRotate.setOnClickListener {
            Toast.makeText(this, "Switch camera", Toast.LENGTH_SHORT).show()
            // TODO: Switch front/back camera
        }

        // "Post" label
        tvPost.setOnClickListener {
            Toast.makeText(this, "Post mode selected", Toast.LENGTH_SHORT).show()
            // TODO: Set mode to "Post"
        }

        // "Story" label
        tvStory.setOnClickListener {
            Toast.makeText(this, "Story mode selected", Toast.LENGTH_SHORT).show()
            // TODO: Set mode to "Story"
        }

        // Thumbnail
        ivThumbnail.setOnClickListener {
            Toast.makeText(this, "Open gallery", Toast.LENGTH_SHORT).show()
            // TODO: Launch gallery picker or handle existing photo
        }
    }
}
