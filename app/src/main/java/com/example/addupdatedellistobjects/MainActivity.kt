package com.example.addupdatedellistobjects

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addupdatedellistobjects.additembody.CreateAddItemBody
import com.example.addupdatedellistobjects.exerciselistbody.CreateExerciseListBody
import com.example.addupdatedellistobjects.ui.theme.AddUpdateDelListObjectsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddUpdateDelListObjectsTheme {
                // A surface container using the 'background' color from the theme

                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val context = LocalContext.current

    val exerciseList = remember {
        mutableStateListOf<ExerciseDataItem>()
    }

    exerciseList.add(ExerciseDataItem("DEsdsdas",R.drawable.yoga))
    val itemToRemove by remember {
        mutableStateOf(-1)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        color = MaterialTheme.colors.background
    ) {
        Column {
            CreateAddItemBody(exerciseList)
            Spacer(modifier = Modifier.height(20.dp))
            CreateExerciseListBody(exerciseList = exerciseList, onButtonClicks = {
                if (itemToRemove != -1) exerciseList.removeAt(itemToRemove)
            })
        }

    }
}




@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AddUpdateDelListObjectsTheme {
        Greeting("Android")
    }
}