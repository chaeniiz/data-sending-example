package com.chaeniiz.datasendingexample

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_name.*

class NameFragment : Fragment() {

    companion object {
        const val HINT = "hint"
        fun newInstance(hint: String): NameFragment {
            val fragment = NameFragment()
            val args = Bundle()
            args.putString(HINT, hint)
            fragment.arguments = args
            return fragment
        }
    }

    private var listener: DoneButtonClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_name, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameEditText.hint = arguments?.getString(HINT)
        doneButton.setOnClickListener { onDoneClicked(nameEditText.text.toString()) }
    }

    interface DoneButtonClickListener {
        fun onDoneClicked(name: String)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is DoneButtonClickListener)
            listener = context
        else
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun onDoneClicked(name: String) {
        listener?.onDoneClicked(name)
    }
}
