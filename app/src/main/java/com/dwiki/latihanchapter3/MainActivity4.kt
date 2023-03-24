package com.dwiki.latihanchapter3

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dwiki.latihanchapter3.databinding.ActivityMain4Binding
import com.dwiki.latihanchapter3.model.Person
import java.io.Serializable

class MainActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(binding.root)

        getDataSerializable()
    }

    private fun getDataSerializable() {
        val person = getSerializable(intent, DATA_PERSON, Person::class.java)

        val name = person.name
        val email = person.email
        val age = person.age
        val address = person.address
        val phone = person.phone

        Log.d("MainActivity4", "name: $name, email: $email, age: $age, address: $address, phone: $phone")

        binding.tvName.text = name
        binding.tvEmail.text = email
        binding.tvAge.text = age.toString()
        binding.tvAddress.text = address
        binding.tvPhone.text = phone


    }

    //deprecated at 33
    private fun <T : Serializable?> getSerializable(intent: Intent, key: String, className: Class<T>): T {
        return if (Build.VERSION.SDK_INT >= 33)
            intent.getSerializableExtra(key, className)!!
        else
            intent.getSerializableExtra(key) as T
    }

    companion object{
        const val DATA_PERSON = "person"
    }

}