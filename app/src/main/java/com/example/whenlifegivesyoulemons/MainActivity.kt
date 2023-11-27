package com.example.whenlifegivesyoulemons

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whenlifegivesyoulemons.ui.theme.WhenLifeGivesYouLemonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var idImage by remember { mutableStateOf(1) }
            var clickCount by remember { mutableStateOf(0) }
            var targetClicks by remember { mutableStateOf(0) }

            WhenLifeGivesYouLemonsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Title(
                        "Lemonade", modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    androidx.compose.material3.Button(
                        onClick = {
                            if (idImage == 4) {
                                idImage = 1
                                targetClicks = 0
                                clickCount = 0
                            } else if (idImage == 2) {
                                clickCount++
                                if (idImage == 2 && clickCount == targetClicks) {
                                    idImage++
                                }
                            } else {
                                if (idImage == 1 && targetClicks == 0) {
                                    targetClicks = (2..4).random()
                                }
                                idImage++
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        ImageCitron(idImage, modifier = Modifier.fillMaxSize())
                    }
                    TextCitron(idImage, modifier = Modifier)
                }
            }

        }
    }


    @Composable
    fun Title(name: String, modifier: Modifier = Modifier) {
        Text(
            text = name,
            modifier = modifier.background(Color.Yellow)
        )
    }

    @Composable
    fun ImageCitron(idImage: Int, modifier: Modifier = Modifier) {
        val imageAndDescription = when (idImage) {
            1 -> R.drawable.lemon_tree to R.string.lemonTree
            2 -> R.drawable.lemon_squeeze to R.string.lemonSqueeze
            3 -> R.drawable.lemon_drink to R.string.lemonDrink
            else -> R.drawable.lemon_restart to R.string.lemonRestart
        }
        Image(
            painter = painterResource(id = imageAndDescription.first),
            contentDescription = stringResource(id = imageAndDescription.second)
        )
    }

    @Composable
    fun TextCitron(idImage: Int, modifier: Modifier = Modifier) {
        val textResourceId = when (idImage) {
            1 -> R.string.selectLemon
            2 -> R.string.squeezeLemon
            3 -> R.string.drinkLemonade
            else -> R.string.emptyTheGlass
        }
        Text(
            text = stringResource(id = textResourceId),
            modifier = modifier
        )
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        var idImage by remember { mutableStateOf(1) }
        var clickCount by remember { mutableStateOf(0) }
        var targetClicks by remember { mutableStateOf(0) }

        WhenLifeGivesYouLemonsTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Title(
                    "Lemonade", modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                androidx.compose.material3.Button(
                    onClick = {
                        if (idImage == 4) {
                            idImage = 1
                            targetClicks = 0
                            clickCount = 0
                        } else if (idImage == 2) {
                            clickCount++
                            if (idImage == 2 && clickCount == targetClicks) {
                                idImage++
                            }
                        } else {
                            if (idImage == 1 && targetClicks == 0) {
                                targetClicks = (2..4).random()
                            }
                            idImage++
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    ImageCitron(idImage, modifier = Modifier.fillMaxSize())
                }
                TextCitron(idImage, modifier = Modifier)
            }
        }
    }
}





