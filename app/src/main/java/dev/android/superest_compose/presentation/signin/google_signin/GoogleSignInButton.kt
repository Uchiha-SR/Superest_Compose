package dev.android.superest_compose.presentation.signin.google_signin


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.android.superest_compose.R

@Composable
fun GoogleSignInButton() {

    val context = LocalContext.current
    val auth = Firebase.auth
    val signingIn = remember { mutableStateOf(false) }
    val googleSignInLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }

    val signInClick: () -> Unit = {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("191079388119-5sbkehk8j0vtfr59ileoun22blrie1uc.apps.googleusercontent.com")
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(context, gso)
        val signInIntent = googleSignInClient.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

    Button(
        onClick = {
            if (!signingIn.value) {
                signingIn.value = true
                signInClick()
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        enabled = !signingIn.value
    ) {
        Text(if (signingIn.value) "Signing In..." else "Sign In with Google")
    }
}

private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
    try {
        val account = completedTask.getResult(ApiException::class.java)
        if (account != null) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            val auth = Firebase.auth
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        val user = auth.currentUser
                    } else {
                        // Sign in failed
                    }
                }
        }
    } catch (e: ApiException) {
        // Sign in failed
    }
}