package com.nmwzd.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nmwzd.nearby.data.model.Market
import com.nmwzd.nearby.ui.screen.HomeScreen
import com.nmwzd.nearby.ui.screen.MarketDetailsScreen
import com.nmwzd.nearby.ui.screen.SplashScreen
import com.nmwzd.nearby.ui.screen.WelcomeScreen
import com.nmwzd.nearby.ui.screen.route.Home
import com.nmwzd.nearby.ui.screen.route.Splash
import com.nmwzd.nearby.ui.screen.route.Welcome
import com.nmwzd.nearby.ui.theme.NearbyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ){
                    composable<Splash>{
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }

                    composable<Welcome>{
                        WelcomeScreen(
                            onNavigateToHome = {
                                navController.navigate(Home)
                            }
                        )
                    }

                    composable<Home>{
                        HomeScreen(onNavigateToMarketDetails = { selectedMarket ->
                            navController.navigate(selectedMarket)
                        })
                    }
                    composable<Market>{
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )

                    }

                }
            }
        }
    }
}
