package com.rakesh.utils

import java.text.SimpleDateFormat
import java.util.*

class Util {

    companion object {
        fun getDate() : String{
            val c = Calendar.getInstance().time
            val df =
                SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
            return df.format(c)
        }
    }
}