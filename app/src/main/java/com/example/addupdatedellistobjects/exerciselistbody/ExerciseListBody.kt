package com.example.addupdatedellistobjects.exerciselistbody

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import com.example.addupdatedellistobjects.R

@Composable
fun CreateExerciseListBody() {
    ExerciseListBoyItem()
}

@Composable
fun ExerciseListBoyItem(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp)),
        color = Color.Gray
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.yoga),
                contentDescription = "Yoga image",
                modifier = modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Yoga is ver good remedy for health. you can do it home, in park on the roof, do it as soon as possible",
                style = MaterialTheme.typography.h5.copy(color = Color.White),
                modifier = modifier
                    .weight(1f)
                    .padding(horizontal = 20.dp),
                maxLines = 1,
            )
            Button(onClick = {}, modifier = modifier.fillMaxHeight()) {
                Text(text = "Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExerciseListBody() {
    CreateExerciseListBody()
}