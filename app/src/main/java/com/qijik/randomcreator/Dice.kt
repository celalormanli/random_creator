package com.qijik.randomcreator

import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom

class Dice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var diceImage:ImageView=findViewById(R.id.diceImage)
        var diceImage1:ImageView=findViewById(R.id.diceImage1)
        var toDice:Button=findViewById(R.id.toDice)
        toDice.setOnClickListener {
            var coin = ThreadLocalRandom.current().nextInt(1,7)
            if(coin==1) {
                diceImage.setImageResource(R.drawable.dice_1)
            }
            if(coin==2) {
                diceImage.setImageResource(R.drawable.dice_2)
            }
            if(coin==3) {
                diceImage.setImageResource(R.drawable.dice_3)
            }
            if(coin==4) {
                diceImage.setImageResource(R.drawable.dice_4)
            }
            if(coin==5) {
                diceImage.setImageResource(R.drawable.dice_5)
            }
            if(coin==6) {
                diceImage.setImageResource(R.drawable.dice_6)
            }
            var coin1 = ThreadLocalRandom.current().nextInt(1,7)
            if(coin1==1) {
                diceImage1.setImageResource(R.drawable.dice_1)
            }
            if(coin1==2) {
                diceImage1.setImageResource(R.drawable.dice_2)
            }
            if(coin1==3) {
                diceImage1.setImageResource(R.drawable.dice_3)
            }
            if(coin1==4) {
                diceImage1.setImageResource(R.drawable.dice_4)
            }
            if(coin1==5) {
                diceImage1.setImageResource(R.drawable.dice_5)
            }
            if(coin1==6) {
                diceImage1.setImageResource(R.drawable.dice_6)
            }


        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
