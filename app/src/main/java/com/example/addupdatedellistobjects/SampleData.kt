package com.example.addupdatedellistobjects

class SampleData {
    companion object {
        var exercisesList =
            listOf(ExerciseDataItem("Yoga is very good for health", R.drawable.yoga))
        var exerciseImageList = listOf(
            R.drawable.yoga,
            R.drawable.breathing,
            R.drawable.fitness,
            R.drawable.holding,
            R.drawable.standing
        )
    }
}

data class ExerciseDataItem(val taskDescription: String, val resourceID: Int)
data class ExercisesImageItem(val id: Int)