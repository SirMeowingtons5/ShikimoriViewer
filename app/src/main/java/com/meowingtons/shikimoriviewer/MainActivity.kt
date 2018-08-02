package com.meowingtons.shikimoriviewer

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val uriIntent = Uri.parse("app://com.meowingtons.shikimoriviewer/login")
            //val uriIntent=Uri.parse("http://google.com")
            val intent = Intent(Intent.ACTION_MAIN)

            intent.data = uriIntent
            startActivity(intent)
        }
    }
}
