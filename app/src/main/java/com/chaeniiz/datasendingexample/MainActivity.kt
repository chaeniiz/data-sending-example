package com.chaeniiz.datasendingexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NameFragment.DoneButtonClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNameFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    NameFragment.newInstance(getString(R.string.hint))).commit()
        }
    }

    override fun onDoneClicked(name: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,
                NicknameFragment.newInstance(name)
            )
            .commit()
    }
}
