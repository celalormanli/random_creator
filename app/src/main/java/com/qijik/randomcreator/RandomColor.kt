package com.qijik.randomcreator

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.activity_random_color.*
import kotlinx.android.synthetic.main.activity_random_color.view.*
import java.sql.Time
import java.util.concurrent.ThreadLocalRandom

class RandomColor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_color)
        var randomColor:TextView=findViewById(R.id.randomColor)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Slidr.attach(this)
        var colorBackground:LinearLayout=findViewById(R.id.colorBackGround)
        colorBackground.setOnClickListener(View.OnClickListener {
            var r=ThreadLocalRandom.current().nextInt(0,256)
            var g=ThreadLocalRandom.current().nextInt(0,256)
            var b=ThreadLocalRandom.current().nextInt(0,256)
            randomColor.text=""
            colorBackground.setBackgroundColor(Color.rgb(r,g,b))
            supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.rgb(r,g,b)))
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
