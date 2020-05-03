package com.qijik.randomcreator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.r0adkll.slidr.Slidr
import java.util.concurrent.ThreadLocalRandom

class NumberCreator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_creator)
        var createNumber: Button = findViewById(R.id.createNumber)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Slidr.attach(this)
        var minNumber: EditText = findViewById(R.id.minNumber)
        var maxNumber: EditText = findViewById(R.id.maxNumber)
        var number: TextView = findViewById(R.id.number)
        createNumber.setOnClickListener {
            if (maxNumber.text.isEmpty() || minNumber.text.isEmpty()) {//TODO:Max sayı aralığı istenecek bide try catch eklenecek
                Toast.makeText(this, resources.getString(R.string.fill_empty_fields), Toast.LENGTH_SHORT).show()
            } else {
                if (minNumber.text.toString().toInt() < maxNumber.text.toString().toInt()) {
                    number.text = ThreadLocalRandom.current().nextInt(
                        minNumber.text.toString().toInt(),
                        maxNumber.text.toString().toInt() + 1
                    ).toString()
                } else {
                    if (minNumber.text.toString().toInt() == maxNumber.text.toString().toInt()) {
                        Toast.makeText(this, resources.getString(R.string.numbers_cannot_be_equal), Toast.LENGTH_SHORT).show()
                    } else {
                            Toast.makeText(this, resources.getString(R.string.the_locations_of_the_numbers_are_wrong), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
