package com.qijik.randomcreator

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
import com.r0adkll.slidr.Slidr
import java.util.concurrent.ThreadLocalRandom

class HeadsOrTails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heads_or_tails)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Slidr.attach(this)
        var flipCoin:Button=findViewById(R.id.flipCoin)
        var tailsOrHeadsImage:ImageView=findViewById(R.id.headsOrTailsImage)
        flipCoin.setOnClickListener {
            for(x in 1..25) {
                if (x<20) {
                    val handler = Handler(Looper.myLooper())
                    handler.postDelayed({
                        flipFun()
                    }, 200 * x.toLong())
                }else{
                    val handler = Handler(Looper.myLooper())
                    handler.postDelayed({
                        if(x%2==0) {
                            tailsOrHeadsImage.visibility = View.INVISIBLE
                            tailsOrHeadsImage.visibility=View.INVISIBLE
                        }
                        else{
                            tailsOrHeadsImage.visibility = View.VISIBLE
                            tailsOrHeadsImage.visibility=View.VISIBLE
                        }
                    }, 250 * x.toLong())
                }
            }


        }
    }
    fun flipFun(){
        var tailsOrHeadsImage:ImageView=findViewById(R.id.headsOrTailsImage)
        var coin = ThreadLocalRandom.current().nextInt(0,1000)
        if (coin%2==0) {

            tailsOrHeadsImage.setImageResource(R.drawable.head)
        }
        else {

            tailsOrHeadsImage.setImageResource(R.drawable.tail)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
