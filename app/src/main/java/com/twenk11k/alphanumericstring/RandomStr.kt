package com.twenk11k.alphanumericstring

import android.os.Build
import android.support.annotation.RequiresApi
import java.util.*
import java.security.SecureRandom

class RandomStr {


    fun nextString(): String {
        for (idx in buf.indices)
            buf[idx] = symbols[random.nextInt(symbols.size)]
        return String(buf)
    }

    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    val lower = upper.toLowerCase(Locale.ROOT)

    val digits = "0123456789"

    val alphanum = upper + lower + digits

    protected lateinit var random: Random

    protected lateinit var symbols: CharArray

    protected lateinit var  buf: CharArray

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    constructor(length: Int, random: Random, symbols: String) {
        if (length < 1) throw IllegalArgumentException()
        if (symbols.length < 2) throw IllegalArgumentException()
        this.random = Objects.requireNonNull(random)
        this.symbols = symbols.toCharArray()
        this.buf = CharArray(length)
    }

    /**
     * Create an alphanumeric string generator.
     */
    constructor(length: Int, random: Random){
        RandomStr(length, random, alphanum)
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    constructor(length: Int){
        RandomStr(length, SecureRandom())
    }

    /**
     * Create session identifiers.
     */
    constructor() {
        RandomStr(21)
    }



}