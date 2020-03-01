package com.qijik.randomcreator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.concurrent.ThreadLocalRandom

class NumberCreator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_creator)
        var createNumber: Button = findViewById(R.id.createNumber)
        var minNumber: EditText = findViewById(R.id.minNumber)
        var maxNumber: EditText = findViewById(R.id.maxNumber)
        var number: TextView = findViewById(R.id.number)
        createNumber.setOnClickListener {
            if (maxNumber.text.isEmpty() || minNumber.text.isEmpty()) {//TODO:Max sayı aralığı istenecek bide try catch eklenecek
                Toast.makeText(this, "Boş alanları doldur", Toast.LENGTH_SHORT).show()
            } else {
                if (minNumber.text.toString().toInt() < maxNumber.text.toString().toInt()) {
                    number.text = ThreadLocalRandom.current().nextInt(
                        minNumber.text.toString().toInt(),
                        maxNumber.text.toString().toInt() + 1
                    ).toString()
                } else {
                    if (minNumber.text.toString().toInt() == maxNumber.text.toString().toInt()) {
                        Toast.makeText(this, "Sayılar eşit olamaz", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Sayı yerleri yanlış", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
