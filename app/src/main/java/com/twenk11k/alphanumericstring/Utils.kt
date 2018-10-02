package com.twenk11k.alphanumericstring

import java.util.*
import java.util.concurrent.ThreadLocalRandom
import android.R.attr.digits
import android.support.annotation.RequiresApi
import java.security.SecureRandom
import android.R.attr.digits




class Utils {

    companion object {
        fun getRandomStr(): `String` {

            val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST".toCharArray()

            val sb = StringBuilder()
            val random = Random()
            for (i in chars.indices) {
                val c = chars[random.nextInt(chars.size)]
                sb.append(c)
            }

            return sb.toString()
        }
        @RequiresApi(21)
        fun randomMethod1(): `String` {
            val easy = "0123456789" + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx"
            val randomStr = RandomStr(8, ThreadLocalRandom.current(),easy)
            return randomStr.nextString()
        }
    }



}