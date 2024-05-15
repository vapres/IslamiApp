package com.route.islamiapp.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiapp.databinding.ItemChapterTitleBinding
import com.route.islamiapp.databinding.ItemVerseBinding


class VersesAdapter(
    private val versesList: List<String>,
) :
    RecyclerView.Adapter<VersesAdapter.myHolder>() {

    class myHolder(val itemBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(verses: String) {
            itemBinding.tvContent.text = verses
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val binding: ItemVerseBinding = ItemVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return myHolder(binding)
    }

    override fun getItemCount() = versesList.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        val verses = versesList[position]
        holder.bind(verses)

    }

}