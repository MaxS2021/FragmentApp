package com.maxencoder.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.maxencoder.fragmentapp.databinding.Fragment1Binding


class BlankFragment : Fragment() {

    private val dataModel: DataModel by activityViewModels()
    lateinit var bind: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = Fragment1Binding.inflate(inflater)
        // Inflate the layout for this fragment
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            bind.twMess1.text = it
        })
        bind.bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello from Fragment 1"
        }
        bind.bSendToAct.setOnClickListener {
            dataModel.messageForActivity.value = "Hello Activity from Fragment 1"
            dataModel.messageForFrag2.value = "Message"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }

}