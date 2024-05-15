package com.route.islamiapp.ui.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islamiapp.databinding.ItemChapterTitleBinding
import com.route.islamiapp.databinding.ItemHadethTitleBinding
import com.route.islamiapp.databinding.ItemVerseBinding


class HadethAdapter(
    private val ahadethList: List<String>,
) :
    RecyclerView.Adapter<HadethAdapter.myHolder>() {

    class myHolder(val itemBinding: ItemHadethTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(hadeth: String) {
            itemBinding.tvHadeth.text = hadeth
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val binding: ItemHadethTitleBinding = ItemHadethTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return myHolder(binding)
    }

    override fun getItemCount() = ahadethList.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        val hadeth = ahadethList[position]
        holder.bind(hadeth)
        onHadethClickListener?.let{listener->
            holder.itemView.setOnClickListener {
                listener.onHadethClick(hadeth, position)
            }
        }
    }

    var onHadethClickListener:OnHadethClickListener?= null
    fun interface OnHadethClickListener {
        fun onHadethClick(hadethTitle: String, position: Int)
    }

}