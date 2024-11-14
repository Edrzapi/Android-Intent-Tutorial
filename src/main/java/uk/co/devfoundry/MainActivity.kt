package uk.co.devfoundry

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.devfoundry.ui.theme.IntentTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntentTutorialTheme {
                Button(modifier = Modifier.padding(105.dp),
                    onClick = { switchToSecondActivity(this) })
                { Text(text = "Switch Activity") }
            }
        }
    }
}

fun switchToSecondActivity(context: Context) {
    val intent = Intent(context, SecondActivity::class.java)
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntentTutorialTheme {
    }
}