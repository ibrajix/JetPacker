/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ibrajix.jetpacker.databinding.ActivityMainBinding
import com.ibrajix.jetpacker.utils.Constants.SPLASH_SCREEN_TIME
import com.ibrajix.jetpacker.utils.Utility.whiteStatusBar
import dagger.hilt.android.AndroidEntryPoint

/**
 * This is the launcher activity which displays on first time visit
 */


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        whiteStatusBar()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize view
        initView()

    }

    private fun initView(){
        startAnimation()
        goToNextActivity()
    }

    private fun startAnimation(){

        YoYo.with(Techniques.RotateInDownLeft)
            .duration(3000)
            .repeat(0)
            .playOn(binding.icLogo)

        YoYo.with(Techniques.RotateInDownRight)
            .duration(3000)
            .repeat(0)
            .playOn(binding.txtSpacex)

        YoYo.with(Techniques.RotateInDownRight)
            .duration(3000)
            .repeat(0)
            .playOn(binding.txtOdyssey)

    }

    /**
     * Normally, I don't use this splash screen implementation approach, I only use this to showcase the startup animation
     */

    private fun goToNextActivity(){

        //delay for 5 seconds and move to next activity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ContainerActivity::class.java)
            startActivity(intent)
            finish()}, SPLASH_SCREEN_TIME)

    }

}