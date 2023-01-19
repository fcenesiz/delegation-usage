package com.fcenesiz.delegationusage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fcenesiz.delegationusage.ui.theme.DelegationUsageTheme

/**
 * Kotlin supports delegation natively!
 */
class MainActivity :
    ComponentActivity(),
    AnalyticsLogger by AnalyticsLoggerImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerLifecycleOwner(this)

        setContent {
            DelegationUsageTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "This is Delegation!")
                }
            }
        }
    }

}
