package com.qijik.randomcreator

import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom

class Dice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        var dice:TextView=findViewById(R.id.dice)
        var diceImage:ImageView=findViewById(R.id.diceImage)
        var toDice:Button=findViewById(R.id.toDice)
        toDice.setOnClickListener {
            var coin = ThreadLocalRandom.current().nextInt(1,7)
//            diceImage.setBackgroundColor(Color.rgb(0,0,0))

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

                dice.text=coin.toString()
        }
    }
}
