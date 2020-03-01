package com.qijik.randomcreator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_random_color.view.*
import java.util.concurrent.ThreadLocalRandom

class RandomColor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_color)
        var colorBackground:LinearLayout=findViewById(R.id.colorBackGround)
        var randomColor:Button=findViewById(R.id.randomColor)
        randomColor.setOnClickListener {
            colorBackground.setBackgroundColor(Color.rgb(ThreadLocalRandom.current().nextInt(0,256),ThreadLocalRandom.current().nextInt(0,256),ThreadLocalRandom.current().nextInt(0,256)))
        }
    }
}
