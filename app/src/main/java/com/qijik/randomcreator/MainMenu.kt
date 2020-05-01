package com.qijik.randomcreator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.main_background))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var mainList:ListView=findViewById(R.id.mainList)
        val arrayAdapter:ArrayAdapter<*>
        val menuList= arrayOf(resources.getString(R.string.number_creator),resources.getString(R.string.password_creator),resources.getString(R.string.heads_or_tails),resources.getString(R.string.dice),resources.getString(R.string.random_color))
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,menuList)
        mainList.adapter=arrayAdapter
        mainList.setOnItemClickListener { parent, view, position, id ->
            if (position==0){
                val intent = Intent(this, NumberCreator::class.java)
                startActivity(intent)
            }
            if (position==1){
                val intent = Intent(this, PasswordCreator::class.java)
                startActivity(intent)
            }
            if (position==2){
                val intent = Intent(this, HeadsOrTails::class.java)
                startActivity(intent)
            }
            if (position==3){
                val intent = Intent(this, Dice::class.java)
                startActivity(intent)
            }
            if (position==4){
                val intent = Intent(this, RandomColor::class.java)
                startActivity(intent)
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        moveTaskToBack(true)
        return super.onOptionsItemSelected(item)
    }
}
