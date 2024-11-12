package com.sophiemiller.exercisehelperapp.data.typeConverters

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sophiemiller.exercisehelperapp.data.MY_TAG
import com.sophiemiller.exercisehelperapp.data.entities.SingleSet

class ConverterSingleSet {
    @TypeConverter
    fun convertSingleSetToString(singleSet: SingleSet): String {
        return Gson().toJson(singleSet.exerciseIdsList.toString())
    }

    @TypeConverter
    fun convertStringToSingleSet(jsonString: String): SingleSet {
        val result = ArrayList<Int>()
        val split = jsonString.replace("[", "").replace("]", "").replace(" ", "").split(",")
        for (n in split) {
            try {
                result.add(n.toInt())
            } catch (e: Exception) {
                Log.e(MY_TAG, "Couldn't add: $n to exerciseSet")
            }
        }
        return SingleSet(result)
    }
}