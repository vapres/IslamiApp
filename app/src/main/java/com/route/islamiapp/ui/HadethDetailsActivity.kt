package com.route.islamiapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islamiapp.R
import com.route.islamiapp.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityHadethDetailsBinding
    lateinit var hadethTitle:String
    var hadethIndex:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    private fun initViews() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        hadethTitle = intent.getStringExtra(Constants.HadethTitle)?:""
        hadethIndex = intent.getIntExtra(Constants.HadethIndex, 0)
        binding.contentHadeth.tvHadethTitle.text = hadethTitle
        readHadethFile()
    }

    private fun readHadethFile() {
        val inputStream = assets.open("${"h$hadethIndex"}.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        binding.contentHadeth.tvHadethContent.text = fileContent
    }
}