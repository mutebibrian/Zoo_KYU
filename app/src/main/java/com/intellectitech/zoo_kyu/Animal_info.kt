package com.intellectitech.zoo_kyu

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Animal_info : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val bundel:Bundle = intent.extras!!
        //To get string from extra activity
        val name = bundel.getString("name")
        val des =bundel.getString("des")
        val image = bundel.getInt("image")
        val ivimage= findViewById<ImageView>(R.id.ivAnimalImage)
        val tvname = findViewById<TextView>(R.id.tvname)
        val desc =findViewById<TextView>(R.id.tvDes)
        ivimage.setImageResource (image)


        //ivimage.setImageDrawable(getResources().getDrawable(R.drawable.baboon));

        tvname.text=name
        desc.text=des
    }
}




