package com.chaeniiz.datasendingexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        nameTextView.text = intent.getStringExtra("name")
        nicknameTextView.text = intent.getStringExtra("nickname")
    }
}
