package com.RehanTariq.i220965

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FollowersAdapter(
    private val followersList: List<Follower>,
    private val onChatClick: (Follower) -> Unit
) : RecyclerView.Adapter<FollowersAdapter.FollowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_follower, parent, false)
        return FollowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        val follower = followersList[position]
        holder.bind(follower, onChatClick)
    }

    override fun getItemCount(): Int = followersList.size

    inner class FollowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivProfilePic: ImageView = itemView.findViewById(R.id.ivProfilePic)
        private val tvFollowerName: TextView = itemView.findViewById(R.id.tvFollowerName)
        private val ivChat: ImageView = itemView.findViewById(R.id.ivChat)

        fun bind(follower: Follower, onChatClick: (Follower) -> Unit) {
            ivProfilePic.setImageResource(follower.profilePicRes)
            tvFollowerName.text = follower.name

            ivChat.setOnClickListener {
                onChatClick(follower)
            }
        }
    }
}
