package com.example.eq.ui.user

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.aq.R

object PersonSinglton{

    init {
        println("Singleton class invoked.")
    }
    var name = "Игорь"
    var lastName = "Николаев"
    var email = "aaa@gmail.com"
    var birthday = ("02 03 2000")
}

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val avatar = findViewById<ImageView>(R.id.avatar)

        val name = findViewById<TextView>(R.id.profile_name)

        val birthday = findViewById<TextView>(R.id.profile_birthday)

        name.text = PersonSinglton.name

        birthday.text = PersonSinglton.birthday

        avatar.setOnClickListener {
            Log.d("CLiCK","image")
            getContent.launch("image/*")
        }
    }

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        Log.d("img", uri.toString())
        val avatar = findViewById<ImageView>(R.id.avatar)
        avatar.setImageURI(uri)
    }
}