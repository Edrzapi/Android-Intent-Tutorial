package uk.co.devfoundry

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)  // Set the layout for the second activity
    }

    // This method must be public and have the correct signature to work with the onClick attribute in XML
    fun sendEmailIntent(view: View) {
        val recipient = "example@example.com" // Replace with the desired recipient email address

        // Create an Intent with action SENDTO and a mailto URI scheme
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$recipient") // Only email apps should handle this
            putExtra(Intent.EXTRA_SUBJECT, "Your Subject Here")  // Optional: Add subject if needed
            putExtra(Intent.EXTRA_TEXT, "Your email body here.") // Optional: Add email body if needed
        }

        // Check if there's an email app that can handle this intent
        if (emailIntent.resolveActivity(packageManager) != null) {
            // Use Intent.createChooser() to show the pop-up with available apps
            startActivity(Intent.createChooser(emailIntent, "Choose an email app"))
        } else {
            // Show a toast if no email app is found
            Toast.makeText(this, "No email app found.", Toast.LENGTH_SHORT).show()
        }
    }
}
