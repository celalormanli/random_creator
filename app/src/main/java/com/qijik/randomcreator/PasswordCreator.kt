package com.qijik.randomcreator

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import com.r0adkll.slidr.Slidr
import kotlinx.android.synthetic.main.activity_password_creator.*
import kotlinx.android.synthetic.main.activity_password_creator.view.*
import java.util.concurrent.ThreadLocalRandom

class PasswordCreator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_creator)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Slidr.attach(this)
        var passLength:SeekBar=findViewById(R.id.passLength)
        var numberState: CheckBox = findViewById(R.id.numberState)
        var upperCaseState: CheckBox = findViewById(R.id.upperCaseState)
        var lowerCaseState: CheckBox = findViewById(R.id.lowerCaseState)
        var symbolState: CheckBox = findViewById(R.id.symbolState)
        var createPassword: Button = findViewById(R.id.createPassword)
        var password: TextView = findViewById(R.id.password)
        var passLenghtValue:TextView=findViewById(R.id.passLengthValue)
        passLength?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                passLenghtValue.text=(progress+5).toString()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {

            }
        })
        createPassword.setOnClickListener {
            var sArray: String = ""
            if (numberState.isChecked) {
                sArray = sArray + "0123456789"
            }
            if (upperCaseState.isChecked) {
                sArray = sArray + "QWERTYUIOPASDFGHJKLZXCVBNM"
            }
            if (lowerCaseState.isChecked) {
                sArray = sArray + "qwertyuopasdfghjklizxcvbnm"
            }
            if (symbolState.isChecked) {
                sArray = sArray + "!'+%&/()=?-#$}{][*/.:,;"
            }
            if(!sArray.isEmpty())
            {
                var pass:String=""
                var sLen:Int=sArray.length
                for(x in 1..passLenghtValue.text.toString().toInt())
                {
                    var c:Char=sArray[ThreadLocalRandom.current().nextInt(0,sLen)]
                    pass=pass+c
                }
                password.text = pass
            }
            else{
                password.text=resources.getString(R.string.select_content)
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}

