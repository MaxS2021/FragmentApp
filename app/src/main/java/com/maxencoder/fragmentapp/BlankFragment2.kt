package com.maxencoder.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.maxencoder.fragmentapp.databinding.Fragment2Binding



class BlankFragment2 : Fragment() {

    lateinit var bind: Fragment2Binding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = Fragment2Binding.inflate(inflater)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            bind.twMessage.text = it
        })
        bind.bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value = "Hello from Fragment 2"
        }
        bind.bSendToAct.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity from Fragment 2"
            dataModel.messageForFrag1.value = "Message"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}