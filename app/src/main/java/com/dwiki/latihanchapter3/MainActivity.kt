package com.dwiki.latihanchapter3

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dwiki.latihanchapter3.MainActivity2.Companion.NAME
import com.dwiki.latihanchapter3.MainActivity2.Companion.YEAR_BORN
import com.dwiki.latihanchapter3.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tanggalLahir: String
    private lateinit var tahunLahir:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDatePicker()
        setupButtonSave()
    }

    private fun setupButtonSave() {
        binding.btnSave.setOnClickListener {
            val name = binding.edtNamaPengguna.text.toString()

            val intent = Intent(this,MainActivity2::class.java)

            val args = Bundle()
            args.putString(NAME,name)
            args.putString(YEAR_BORN,tahunLahir)
            intent.putExtras(args)
            startActivity(intent)
        }
    }

    private fun setupDatePicker() {
        binding.edtTanggalLahir.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, year, month, dayOfMonth ->
                    tanggalLahir = "$dayOfMonth/${month + 1}/$year"
                    tahunLahir = "$year"
                    binding.edtTanggalLahir.setText(tanggalLahir)
                },
                year, month, day,
            )
            datePickerDialog.show()
        }
    }

}