package com.kito.kitoextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kito.kitoextension.databinding.ActivityMainBinding
import com.kito.visibility.gone
import com.kito.visibility.logd
import com.kito.visibility.showToast

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvaa.text.toString().logd("ljfaewlk")
        Log.d("gareerher", "onCreate: ${binding.tvaa.text}")
        showToast("hrreherh")
    }
}