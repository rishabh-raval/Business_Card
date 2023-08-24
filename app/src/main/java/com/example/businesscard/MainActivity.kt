package com.example.businesscard

import android.icu.text.ListFormatter.Width
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile()
                    //Color(0xFF3ddc84)
                }
            }
        }
    }
}

@Composable
fun Profile() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        val name = "Rishabh Raval"
        val title = "Android Developer Extraordinaire"
        Intro(image, name, title)
        Spacer(modifier = Modifier.height(150.dp))
        val number = "+1 819-555-1234"
        val reach = "@Android/Dev"
        val email = "rar/dev@android.com"
        Details(number, reach, email)
    }
}

@Composable
fun Intro(image: Painter, name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.foundation.Image(painter = image, contentDescription = null, modifier = Modifier
            .padding(5.dp)
            .width(225.dp))
        Text(text = name,
            fontSize = 30.sp,
            modifier = Modifier.padding(5.dp)
        )
        Text(text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
            color = Color(0xFF3ddc84),
            fontSize = 15.sp
        )
    }
}

@Composable
fun Details(number: String, reach: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val callLogo = painterResource(id = R.drawable.call_32)
            androidx.compose.foundation.Image(
                painter = callLogo,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = number,
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val shareLogo = painterResource(id = R.drawable.share_32)
            androidx.compose.foundation.Image(painter = shareLogo,
                contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = reach,
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp)
        }


        Row(
            modifier = Modifier
                .fillMaxWidth().padding(horizontal = 50.dp).padding(bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val emailLogo = painterResource(id = R.drawable.email_32)
            androidx.compose.foundation.Image(painter = emailLogo,
                contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = email,
                modifier = Modifier.padding(8.dp),
                fontSize = 20.sp)
        }
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Profile()
    }
}