package com.route.islamiapp.ui.chapterDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.route.islamiapp.databinding.ActivityChapterDetailsBinding
import com.route.islamiapp.ui.Constants

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityChapterDetailsBinding
    lateinit var chapterTitle: String
    var chapterIndex: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        chapterTitle = intent.getStringExtra(Constants.ChapterTitle) ?: ""
        chapterIndex = intent.getIntExtra(Constants.ChapterIndex, 0)
        binding.contentChapter.tvChapterTitle.text = chapterTitle
        readChapterFile()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun readChapterFile() {
        val inputStream = assets.open("$chapterIndex.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("/n")
        initRecycler(lines)
    }

    private fun initRecycler(verses: List<String>) {
        val adapter = VersesAdapter(verses)
        binding.contentChapter.rvVerses.adapter = adapter
    }
}