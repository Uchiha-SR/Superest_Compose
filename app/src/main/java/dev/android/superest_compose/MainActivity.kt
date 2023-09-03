package dev.android.superest_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.AndroidEntryPoint

import dev.android.superest_compose.ui.theme.Superest_ComposeTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Superest_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                  //  color = MaterialTheme.colors.background
                ) {
               //   SplashScreen()
                 //  Navigation()
               //     GoogleSignIn()
              //      GoogleSignInButton()

                }
            }
        }

         fun getGoogleLoginAuth(): GoogleSignInClient {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestId()
                .requestProfile()
                .build()
            return GoogleSignIn.getClient(this, gso)
        }




    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

