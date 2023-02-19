package com.maxencoder.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.maxencoder.fragmentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        openFragment(BlankFragment.newInstance(), R.id.place_holder)
        openFragment(BlankFragment2.newInstance(), R.id.place_holder2)

        dataModel.messageForActivity.observe(this, {
            bind.textView.text = it
        })

    }

    private fun openFragment(f:Fragment, idHolder: Int) {
        supportFragmentManager.
        beginTransaction().
        replace(idHolder, f)
            .commit()

    }
}