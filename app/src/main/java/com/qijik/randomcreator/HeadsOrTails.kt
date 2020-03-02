package com.qijik.randomcreator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.concurrent.ThreadLocalRandom

class HeadsOrTails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var flipCoin:Button=findViewById(R.id.flipCoin)
        var tailsOrHeadsImage:ImageView=findViewById(R.id.headsOrTailsImage)
        var headsOrTails:TextView=findViewById(R.id.headsOrTails)
        flipCoin.setOnClickListener {
            var coin = ThreadLocalRandom.current().nextInt(0,1000)
            if (coin%2==0) {
                headsOrTails.text = "Heads"
                tailsOrHeadsImage.setImageResource(R.drawable.head)
            }
            else {
                headsOrTails.text = "Tails"
                tailsOrHeadsImage.setImageResource(R.drawable.tail)
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
