/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ibrajix.jetpacker.R
import com.ibrajix.jetpacker.utils.Utility.whiteStatusBar
import dagger.hilt.android.AndroidEntryPoint

/**
 * This activity hosts the entire fragments
 */

@AndroidEntryPoint
class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        whiteStatusBar()
        setContentView(R.layout.activity_container)
    }
}