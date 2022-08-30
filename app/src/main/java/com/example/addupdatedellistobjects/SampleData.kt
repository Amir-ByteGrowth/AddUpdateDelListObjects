package com.example.addupdatedellistobjects

class SampleData {
    companion object {
        var exercisesList =
            listOf(ExerciseDataItem("Yoga is very good for health", R.drawable.yoga))
    }
}

data class ExerciseDataItem(val taskDescription: String, val resourceID: Int)