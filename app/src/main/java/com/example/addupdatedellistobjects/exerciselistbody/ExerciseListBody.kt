package com.example.addupdatedellistobjects.exerciselistbody

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addupdatedellistobjects.ExerciseDataItem
import com.example.addupdatedellistobjects.R

@Composable
fun CreateExerciseListBody(
    exerciseList: MutableList<ExerciseDataItem>,
    onButtonClicks: () -> Unit
) {
    LazyColumn {
        itemsIndexed(exerciseList) { index, item ->
            ExerciseListBoyItem(
                item,
                onButtonClick = { exerciseList.removeAt(index) })

        }
    }
//    ExerciseListBoyItem()
}

@Composable
fun ExerciseListBoyItem(

    exerciseDataItem: ExerciseDataItem,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp).padding(vertical = 4.dp)
            .clip(RoundedCornerShape(20.dp)),
        color = Color.Gray
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = exerciseDataItem.resourceID),
                contentDescription = "Yoga image",
                modifier = modifier.size(70.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = exerciseDataItem.taskDescription,
                style = MaterialTheme.typography.h5.copy(color = Color.White),
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp),
                maxLines = 1,
            )
            Button(onClick = onButtonClick, modifier = modifier.fillMaxHeight()) {
                Text(text = "Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExerciseListBody() {
    CreateExerciseListBody(
        mutableListOf(ExerciseDataItem("Here is description", R.drawable.yoga)),
        onButtonClicks = {})
}