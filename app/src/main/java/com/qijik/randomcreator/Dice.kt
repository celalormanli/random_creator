package com.qijik.randomcreator

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.activity_dice.*
import java.sql.Time
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class Dice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var diceImage:ImageView=findViewById(R.id.diceImage)
        var diceImage1:ImageView=findViewById(R.id.diceImage1)
        var toDice:Button=findViewById(R.id.toDice)
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage1.setImageResource(R.drawable.dice_1)
        Slidr.attach(this)
        val timer = Timer("schedule", true);
        toDice.setOnClickListener {
            for(x in 1..25) {
                if (x<20) {
                    val handler = Handler(Looper.myLooper())
                    handler.postDelayed({
                        toDiceFun()
                    }, 200 * x.toLong())
                }else{
                    val handler = Handler(Looper.myLooper())
                    handler.postDelayed({
                        if(x%2==0) {
                            diceImage.visibility = View.INVISIBLE
                            diceImage1.visibility=View.INVISIBLE
                        }
                        else{
                            diceImage.visibility = View.VISIBLE
                            diceImage1.visibility=View.VISIBLE
                        }
                    }, 250 * x.toLong())
                }
                }


            }
        }
    fun toDiceFun(){
        var coin = ThreadLocalRandom.current().nextInt(1, 7)
        if (coin == 1) {
            diceImage.setImageResource(R.drawable.dice_1)
        }
        if (coin == 2) {
            diceImage.setImageResource(R.drawable.dice_2)
        }
        if (coin == 3) {
            diceImage.setImageResource(R.drawable.dice_3)
        }
        if (coin == 4) {
            diceImage.setImageResource(R.drawable.dice_4)
        }
        if (coin == 5) {
            diceImage.setImageResource(R.drawable.dice_5)
        }
        if (coin == 6) {
            diceImage.setImageResource(R.drawable.dice_6)
        }
        var coin1 = ThreadLocalRandom.current().nextInt(1, 7)
        if (coin1 == 1) {
            diceImage1.setImageResource(R.drawable.dice_1)
        }
        if (coin1 == 2) {
            diceImage1.setImageResource(R.drawable.dice_2)
        }
        if (coin1 == 3) {
            diceImage1.setImageResource(R.drawable.dice_3)
        }
        if (coin1 == 4) {
            diceImage1.setImageResource(R.drawable.dice_4)
        }
        if (coin1 == 5) {
            diceImage1.setImageResource(R.drawable.dice_5)
        }
        if (coin1 == 6) {
            diceImage1.setImageResource(R.drawable.dice_6)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
