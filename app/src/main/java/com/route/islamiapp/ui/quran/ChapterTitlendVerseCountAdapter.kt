package com.route.islamiapp.ui.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiapp.databinding.ItemChapterTitleBinding


class ChapterTitlendVerseCountAdapter(
    private val chapterList: List<String>,
    private val verseCountList: List<String>
) :
    RecyclerView.Adapter<ChapterTitlendVerseCountAdapter.myHolder>() {

    class myHolder(val itemBinding: ItemChapterTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(chapterTitle: String, verseCount: String) {
            itemBinding.tvChapterTitle.text = chapterTitle
            itemBinding.tvVersesCount.text = verseCount
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val binding: ItemChapterTitleBinding = ItemChapterTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return myHolder(binding)
    }

    override fun getItemCount() = chapterList.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        val chapterTitle = chapterList[position]
        val verseCount = verseCountList[position]
        holder.bind(chapterTitle, verseCount)
        onChapterClickListener?.let {listener ->
            holder.itemView.setOnClickListener {
                listener.onChapterClick(chapterTitle, position)
            }
        }

    }


    var onChapterClickListener: OnChapterClickListener? = null
    fun interface OnChapterClickListener {
        fun onChapterClick(chapterTitle: String, position: Int)
    }
}