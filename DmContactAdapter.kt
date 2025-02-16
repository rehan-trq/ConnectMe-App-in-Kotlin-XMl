package com.RehanTariq.i220965

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DmContactAdapter(
    private val dmList: List<DmContact>,
    private val onCameraClick: (DmContact) -> Unit,
    private val onContactClick: (DmContact) -> Unit
) : RecyclerView.Adapter<DmContactAdapter.DmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dm_contact, parent, false)
        return DmViewHolder(view)
    }

    override fun onBindViewHolder(holder: DmViewHolder, position: Int) {
        val contact = dmList[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = dmList.size

    inner class DmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        private val textViewContactName: TextView = itemView.findViewById(R.id.textViewContactName)
        private val buttonCamera: ImageButton = itemView.findViewById(R.id.buttonCamera)

        fun bind(contact: DmContact) {
            textViewContactName.text = contact.name
            imageViewAvatar.setImageResource(contact.avatarRes)

            // 1) Camera icon click
            buttonCamera.setOnClickListener {
                onCameraClick(contact)
            }

            // 2) Entire row click -> open chat
            itemView.setOnClickListener {
                onContactClick(contact)
            }
        }
    }
}
