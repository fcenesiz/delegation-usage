package com.fcenesiz.delegationusage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fcenesiz.delegationusage.analytics.AnalyticsLogger
import com.fcenesiz.delegationusage.analytics.AnalyticsLoggerImpl
import com.fcenesiz.delegationusage.deeplink.DeepLinkHandleImpl
import com.fcenesiz.delegationusage.deeplink.DeepLinkHandler
import com.fcenesiz.delegationusage.lazy.MyLazy
import com.fcenesiz.delegationusage.ui.theme.DelegationUsageTheme

/**
 * Kotlin supports delegation natively!
 */
class MainActivity :
    ComponentActivity(),
    AnalyticsLogger by AnalyticsLoggerImpl(),
    DeepLinkHandler by DeepLinkHandleImpl() {

    private val obj by MyLazy {
        println("Hello world")
        3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerLifecycleOwner(this)

        println(obj)

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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeepLink(this, intent)
    }

}
