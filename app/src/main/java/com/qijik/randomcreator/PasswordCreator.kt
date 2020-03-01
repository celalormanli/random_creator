package com.qijik.randomcreator

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_password_creator.*
import java.util.concurrent.ThreadLocalRandom

class PasswordCreator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_creator)
        var numberState: CheckBox = findViewById(R.id.numberState)
        var upperCaseState: CheckBox = findViewById(R.id.upperCaseState)
        var lowerCaseState: CheckBox = findViewById(R.id.lowerCaseState)
        var symbolState: CheckBox = findViewById(R.id.symbolState)
        var passwordLength: EditText = findViewById(R.id.passwordLength)
        var createPassword: Button = findViewById(R.id.createPassword)
        var password: TextView = findViewById(R.id.password)
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
            if (!passwordLength.text.isEmpty()) {
                if (passwordLength.text.toString().toInt() >=4  && passwordLength.text.toString().toInt() <= 50) {
                    if(!sArray.isEmpty())
                    {
                        var pass:String=""
                        var sLen:Int=sArray.length
                        for(x in 1..passwordLength.text.toString().toInt())
                        {
                            var c:Char=sArray[ThreadLocalRandom.current().nextInt(0,sLen)]
                            pass=pass+c
                        }
                        password.text = pass
                    }
                    else{
                        password.text="İçerik seç"
                    }
                } else {
                    password.text = "Belirtilen aralığı seç"
                }
            } else {
                password.text = "Sayı gir"
            }
        }
    }
}

