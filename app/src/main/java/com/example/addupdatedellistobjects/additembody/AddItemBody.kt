package com.example.addupdatedellistobjects.additembody

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addupdatedellistobjects.ExercisesImageItem
import com.example.addupdatedellistobjects.R
import com.example.addupdatedellistobjects.SampleData

import com.example.addupdatedellistobjects.exerciselistbody.CreateExerciseListBody

@Composable
fun CreateAddItemBody(modifier: Modifier = Modifier) {

    var itemPosition by remember {
        mutableStateOf(-1)
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        color = Color.Cyan
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {

            Row(
                modifier = modifier
                    .padding(horizontal = 10.dp, vertical = 20.dp)
                    .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(modifier = modifier.weight(1f),
                    value = "",
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {},
                    placeholder = { Text(text = "Enter Description here", color = Color.White) }
                )
                OutlinedButton(onClick = {}, modifier = modifier
                    .fillMaxHeight()
                    .width(100.dp)) {
                    Text(text = "Add")
                }
            }

            LazyRow(modifier = modifier.padding(horizontal = 10.dp)) {

                itemsIndexed(SampleData.exerciseImageList) { index, item ->
                    CreateHorizontalExerciseList(
                        exercisesImageItem = item,
                        modifier = modifier,
                        isBorderEnabled = index == itemPosition
                    ) {
                        itemPosition = index

                    }
                }


            }
        }


    }
}


@Composable
fun CreateHorizontalExerciseList(
    exercisesImageItem: Int,
    modifier: Modifier = Modifier,
    isBorderEnabled: Boolean,
    onSurfaceClick: () -> Unit
) {
    Surface(

        modifier = modifier
            .border(width = 1.dp, color = if (isBorderEnabled) Color.Red else Color.Transparent)
            .padding(3.dp)
            .clickable(onClick = onSurfaceClick),
        color = Color.Transparent
    ) {
        Image(
            painter = painterResource(id = exercisesImageItem),
            contentDescription = "",
            modifier = modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHorizontalExerciseList() {
    CreateAddItemBody()
}