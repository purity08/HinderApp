package com.hinderapp.ui.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.hinderapp.R
import com.hinderapp.ui.main.MainFragment

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}