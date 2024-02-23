package org.abubaker.learntogether

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.abubaker.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PostArticle()
                }
            }
        }
    }
}


@Composable
fun PostArticle() {

    PostCard(
        postTitle = stringResource(R.string.post_title),
        postDesc = stringResource(R.string.post_desc),
        postContent = stringResource(R.string.post_content),
        postThumbnail = painterResource(R.drawable.bg_compose_background)
    )

}

@Composable
fun PostCard(
    postTitle: String,
    postDesc: String,
    postContent: String,
    postThumbnail: Painter
) {

    Column {
        Image(
            painter = postThumbnail,
            contentDescription = null
        )

        Text(
            text = postTitle,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = postDesc,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = postContent,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }


}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        PostArticle()
    }
}