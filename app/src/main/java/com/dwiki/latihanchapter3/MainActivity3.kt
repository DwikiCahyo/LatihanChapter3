package com.dwiki.latihanchapter3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dwiki.latihanchapter3.MainActivity4.Companion.DATA_PERSON
import com.dwiki.latihanchapter3.databinding.ActivityMain3Binding
import com.dwiki.latihanchapter3.model.Person

class MainActivity3 : AppCompatActivity() {



    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSave.setOnClickListener {

            val name =  binding.name.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()
            val address = binding.edtAddresss.text.toString()
            val age = binding.edtAge.text.toString()

            val data = Person(name, email, phone, address, age.toInt())
            val intent = Intent(this,MainActivity4::class.java)
            intent.putExtra(DATA_PERSON,data)
            startActivity(intent)

        }

    }
}