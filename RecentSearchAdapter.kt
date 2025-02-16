// RecentSearchAdapter.kt
package com.RehanTariq.i220965

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecentSearchAdapter(
    private var searchList: MutableList<SearchItem>
) : RecyclerView.Adapter<RecentSearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_search, parent, false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = searchList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = searchList.size

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewSearchName: TextView = itemView.findViewById(R.id.textViewSearchName)
        private val buttonRemoveSearch: ImageButton = itemView.findViewById(R.id.buttonRemoveSearch)

        fun bind(item: SearchItem) {
            textViewSearchName.text = item.name
            buttonRemoveSearch.setOnClickListener {
                // Example: remove the item from the list
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    searchList.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    /**
     * Optional helper function if you want to update the entire list at once.
     */
    fun updateList(newList: MutableList<SearchItem>) {
        searchList = newList
        notifyDataSetChanged()
    }
}
