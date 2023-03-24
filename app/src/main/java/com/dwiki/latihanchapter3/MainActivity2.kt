package com.dwiki.latihanchapter3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dwiki.latihanchapter3.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupGetData()
        nextActivity()
    }

    private fun nextActivity() {
        binding.btnNext.setOnClickListener {
            val intent = Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
    }

    private fun setupGetData() {
        val args = intent.extras
        val name = args?.getString(NAME)
        val yearBorn = args?.getString(YEAR_BORN)
        val age = 2023- yearBorn?.toInt()!!


        binding.tvName.text ="Nama $name"
        binding.tvDob.text = "Umur $age"
    }

    companion object{
        const val NAME = "name"
        const val YEAR_BORN = "year"
    }
}