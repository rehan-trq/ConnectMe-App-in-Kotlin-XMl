package com.RehanTariq.i220965

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ProfilePostsAdapter(
    private val postImages: List<PostImage>
) : RecyclerView.Adapter<ProfilePostsAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val postImage = postImages[position]
        holder.imageView.setImageResource(postImage.imageResId)
    }

    override fun getItemCount(): Int = postImages.size

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivPostImage)
    }
}
