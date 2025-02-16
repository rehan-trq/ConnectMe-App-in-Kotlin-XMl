package com.RehanTariq.i220965
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_INCOMING = 1
        private const val VIEW_TYPE_OUTGOING = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isIncoming) VIEW_TYPE_INCOMING else VIEW_TYPE_OUTGOING
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_INCOMING -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_incoming, parent, false)
                IncomingViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat_outgoing, parent, false)
                OutgoingViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        when (holder) {
            is IncomingViewHolder -> {
                holder.textViewIncomingText.text = message.text
                holder.textViewIncomingTime.text = message.timestamp
            }
            is OutgoingViewHolder -> {
                holder.textViewOutgoingText.text = message.text
                holder.textViewOutgoingTime.text = message.timestamp
            }
        }
    }

    override fun getItemCount(): Int = messages.size

    class IncomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewIncomingText: TextView = itemView.findViewById(R.id.textViewIncomingText)
        val textViewIncomingTime: TextView = itemView.findViewById(R.id.textViewIncomingTime)
    }

    class OutgoingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewOutgoingText: TextView = itemView.findViewById(R.id.textViewOutgoingText)
        val textViewOutgoingTime: TextView = itemView.findViewById(R.id.textViewOutgoingTime)
    }
}
