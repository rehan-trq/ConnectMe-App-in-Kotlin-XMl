// ContactsAdapter.kt
package com.RehanTariq.i220965

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private val items: List<ContactListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_CONTACT = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ContactListItem.SectionHeader -> VIEW_TYPE_HEADER
            is ContactListItem.Contact -> VIEW_TYPE_CONTACT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_section_header, parent, false)
                SectionHeaderViewHolder(view)
            }
            VIEW_TYPE_CONTACT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_contact, parent, false)
                ContactViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is SectionHeaderViewHolder -> {
                val headerItem = item as ContactListItem.SectionHeader
                holder.bind(headerItem)
            }
            is ContactViewHolder -> {
                val contactItem = item as ContactListItem.Contact
                holder.bind(contactItem)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    // 1) Section Header ViewHolder
    class SectionHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewSectionTitle: TextView = itemView.findViewById(R.id.textViewSectionTitle)
        fun bind(header: ContactListItem.SectionHeader) {
            textViewSectionTitle.text = header.title
        }
    }

    // 2) Contact ViewHolder
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        private val buttonChat: ImageButton = itemView.findViewById(R.id.buttonChat)
        private val buttonInvite: Button = itemView.findViewById(R.id.buttonInvite)

        fun bind(contact: ContactListItem.Contact) {
            textViewName.text = contact.name
            imageViewAvatar.setImageResource(contact.avatarRes)

            if (contact.inContacts) {
                // Show chat icon, hide invite button
                buttonChat.visibility = View.VISIBLE
                buttonInvite.visibility = View.GONE
            } else {
                // Show invite button, hide chat icon
                buttonChat.visibility = View.GONE
                buttonInvite.visibility = View.VISIBLE
            }

            // Example click listeners
            buttonChat.setOnClickListener {
                // e.g., open chat with contact
            }
            buttonInvite.setOnClickListener {
                // e.g., send invite
            }
        }
    }
}
