package com.chaeniiz.datasendingexample

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_nickname.*

class NicknameFragment : Fragment() {

    companion object {
        const val NAME = "name"
        const val NICKNAME = "nickname"
        fun newInstance(name: String): NicknameFragment {
            val fragment = NicknameFragment()
            val args = Bundle()
            args.putString(NAME, name)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_nickname, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView.text = arguments?.getString(NAME)
        doneButton.setOnClickListener { onDoneClicked() }
    }

    private fun onDoneClicked() {
        val intent = Intent(context, SubActivity::class.java)
        intent.putExtra(NAME, nameTextView.text.toString())
        intent.putExtra(NICKNAME, nicknameEditText.text.toString())

        startActivity(intent)
    }
}
