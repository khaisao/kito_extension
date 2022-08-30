package com.kito.kitoextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kito.kitoextension.databinding.ActivityMainBinding
import com.kito.visibility.base.BaseActivity
import com.kito.visibility.gone
import com.kito.visibility.logd
import com.kito.visibility.showToast

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setUpViews() {
        super.setUpViews()
        binding.tvaa.text.toString().logd("ljfaewlk")
        Log.d("gareerher", "onCreate: ${binding.tvaa.text}")
        showToast("hrreherh")
    }

    override fun addData() {
        super.addData()
    }

    override fun addObservers() {
        super.addObservers()

    }



    override fun getLayoutId(): Int = R.layout.activity_main
}