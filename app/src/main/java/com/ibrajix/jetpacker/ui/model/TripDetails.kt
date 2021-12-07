/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TripDetails  (
    val spaceCraft: String,
    val station: String,
    val orbit: String,
    val type: String,
    val fair_1: String = "-",
    val fair_2: String = "-",
    val fair_3: String = "-",
    val btc_1: String = "-",
    val btc_2: String = "-",
    val btc_3: String = "-"
) : Parcelable