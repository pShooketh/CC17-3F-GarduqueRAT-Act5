package dev.codeninja.ArtSpace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.starry_night
    val secondArtwork = R.drawable.american_gothic
    val thirdArtwork = R.drawable.madame_x
    val fourthArtwork = R.drawable.pearl_earring

    var title by remember {
        mutableStateOf(R.string.starry_night)
    }

    var author by remember {
        mutableStateOf(R.string.starry_night_author)
    }

    var year by remember {
        mutableStateOf(R.string.starry_night_year)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    var imageResource by remember {
        mutableStateOf(currentArtwork)
    }


    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = modifier.size(16.dp))
        ArtworkTitle(title = title, author = author, year = year)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            // Previous Button
            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.pearl_girl
                            author = R.string.pearl_girl_author
                            year = R.string.pearl_girl_year
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.mona_lisa
                            author = R.string.mona_lisa_author
                            year = R.string.mona_lisa_year
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.ame_gothic
                            author = R.string.ame_gothic_author
                            year = R.string.ame_gothic_year
                        }
                        else -> {
                            currentArtwork = thirdArtwork
                            title = R.string.madam_x
                            author = R.string.madam_x_author
                            year = R.string.madam_x_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.gray_900)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.blue_300)
                )
            }


            Button(
                onClick = {
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.ame_gothic
                            author = R.string.ame_gothic_author
                            year = R.string.ame_gothic_year
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.madam_x
                            author = R.string.madam_x_author
                            year = R.string.madam_x_year
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.pearl_girl
                            author = R.string.pearl_girl_author
                            year = R.string.pearl_girl_year
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.mona_lisa
                            author = R.string.mona_lisa_author
                            year = R.string.mona_lisa_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.blue_300)
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.gray_900)
                )
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.ame_gothic),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes author: Int,
    @StringRes year: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Artwork title
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp
        )

        // Artwork author
        Text(
            text = stringResource(id = author),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300)
        )

        // Artwork year
        Text(
            text = "— ${stringResource(id = year)} —",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}





<string name="app_name" translatable="false">Art Space</string>
<!--First-->
<string name="starry_night">Starry Night</string>
<string name="starry_night_author">Vincent Van Gogh</string>
<string name="starry_night_year">March 1853 – 29 July 1890</string>
<!--Second-->
<string name="ame_gothic">American Gothic</string>
<string name="ame_gothic_author">Grant Wood</string>
<string name="ame_gothic_year">1930</string>
<!--Third-->
<string name="madam_x">Portrait of Madame X</string>
<string name="madam_x_author">John Singer Sargent</string>
<string name="madam_x_year">1884</string>
<!--Forth-->
<string name="pearl_girl">Girl with a Pearl Earring</string>
<string name="pearl_girl_author">Johannes Vermeer</string>
<string name="pearl_girl_year">2020</string>
</resources>