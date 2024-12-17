package com.aquanusa.aquasmart.navigation

import android.R.attr.content
import android.R.id.content
import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.aquanusa.aquasmart.partials.BottomNavigation
import com.aquanusa.aquasmart.partials.beranda.HeaderBeranda
import com.aquanusa.aquasmart.partials.NavbarTop
import com.aquanusa.aquasmart.partials.kelola.HeaderKelola
import com.aquanusa.aquasmart.view.BerandaScreen
import com.aquanusa.aquasmart.view.autentikasi.BeforeLogin
import com.aquanusa.aquasmart.view.autentikasi.LoginScreen
import com.aquanusa.aquasmart.view.kelola.ikan.KelolaIkanMain
import com.aquanusa.aquasmart.view.kelola.kolam.KelolaKolamMain
import com.aquanusa.aquasmart.view.kelola.pakan.KelolaPakanMain
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.view.ParentView
import com.aquanusa.aquasmart.view.autentikasi.AuthenticatedNavigation
import com.aquanusa.aquasmart.view.custom.LoadingScreen
import com.aquanusa.aquasmart.view.kelola.ikan.JadwalPanenScreen
import com.aquanusa.aquasmart.view.kelola.ikan.KematianIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.StokIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.jadwal_panen.TambahJadwalPanenScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.kematian_ikan.TambahKematianIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.stok_ikan.TambahStokIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.edit.jadwal_panen.EditJadwalPanenScreen
import com.aquanusa.aquasmart.view.kelola.ikan.edit.stok_ikan.EditStokIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.overview.OverviewStokIkan
import com.aquanusa.aquasmart.view.kelola.kolam.EditKolamScreen
import com.aquanusa.aquasmart.view.kelola.kolam.TambahKolamScreen
import com.aquanusa.aquasmart.view.kelola.pakan.JadwalPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.PenghitungDosisPakan
import com.aquanusa.aquasmart.view.kelola.pakan.StokPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.add.jadwal_pakan.TambahJadwalPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.add.stok_pakan.TambahStokPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.edit.jadwal_pakan.EditJadwalPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.edit.stok_pakan.EditStokPakanScreen
import com.aquanusa.aquasmart.view.notifikasi.NotifikasiScreen
import com.aquanusa.aquasmart.view.profile.BeforeProfileScreen
import com.aquanusa.aquasmart.view.profile.EditProfileScreen
import com.aquanusa.aquasmart.view.profile.ProfileScreen
import com.aquanusa.aquasmart.viewmodel.autentikasi.PoolViewModel
import com.aquanusa.aquasmart.viewmodel.ikan.ViewModelIkan
import com.aquanusa.aquasmart.viewmodel.pakan.ViewModelPakan
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var back = false
    var title by remember { mutableStateOf("") }

    val uiSystemTheme = rememberSystemUiController()

    val sharedPreferences =
        LocalContext.current.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    val token = sharedPreferences.getString("TOKEN_KEY", null)

//    Tema ui system nya
    uiSystemTheme.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = false
    )

    NavHost(
        navController = navController,
        startDestination = "auth",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        // Graph untuk autentikasi
        navigation(startDestination = "Before Login", route = "auth") {
            composable("Before Login") {
                BeforeLogin(navController)
            }

            composable("Login") {

                LoginScreen(navController)
            }
            composable("Beranda") {
                ParentView(navController)
            }
        }


        // Graph untuk main app dengan bottom bar
//        navigation(startDestination = "Beranda", route = "main") {
//            composable("Beranda") {
//                ParentView(navController)
//            }
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = false
//                        title = ""
//
////                        NavbarTop(navController, back = back, titleScreen = title)
////                        HeaderBeranda()
////                        BerandaScreen(navController)
//                        ParentView(navController)
//                    }
//                }
//            }


//            composable("Notifikasi") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Notifikasi"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        NotifikasiScreen()
//                    }
//                }
//            }
//
//
//////////////////////////    KELOLA IKAN    ///////////////////////
//            composable("Kelola Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = false
//                        title = ""
//
//                        NavbarTop(navController, back = back, titleScreen = title)
////                        HeaderKelola(navController)
//                        KelolaIkanMain()
//                    }
//                }
//            }
//
//            composable("Test Kelola") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = false
//                        title = ""
//
//                        allKelola(navController, back = back, titleScreen = title)
//                    }
//                }
//            }
//            composable("Stok Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Stok Ikan") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        StokIkanScreen(navController)
//                    }
//                }
//            }
//            composable("Jadwal Panen") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Jadwal") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Panen"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        JadwalPanenScreen(navController)
//                    }
//                }
//            }
//            composable("Kematian Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Kematian Ikan") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Kematian Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        KematianIkanScreen(navController)
//                    }
//                }
//            }
//            // ADD
//            composable("Tambah Stok Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahStokIkanScreen(navController)
//                    }
//                }
//            }
//            composable("Tambah Jadwal") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Panen"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahJadwalPanenScreen(navController)
//                    }
//                }
//            }
//            composable("Tambah Kematian Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Kematian Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahKematianIkanScreen(navController)
//                    }
//                }
//            }
//            // OVERVIEW
//            composable("Overview Stok Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        OverviewStokIkan()
//                    }
//                }
//            }
//            // EDIT
//            composable("Edit Stok Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Ikan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditStokIkanScreen(navController)
//                    }
//                }
//            }
//            composable("Edit Jadwal Panen") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Panen"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditJadwalPanenScreen(navController)
//                    }
//                }
//            }
//            composable("Edit Kematian Ikan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Panen"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditJadwalPanenScreen(navController)
//                    }
//                }
//            }
//////////////////////////    END KELOLA IKAN    ///////////////////////
//
//
//////////////////////////    KELOLA KOLAM    ///////////////////////
//            composable("Kelola Kolam") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Kolam") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = false
//                        title = ""
//
//                        NavbarTop(navController, back = back, titleScreen = title)
////                        HeaderKelola(navController)
//                        KelolaKolamMain(navController)
//                    }
//                }
//            }
//            // ADD
//            composable("Tambah Kolam") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Kelola Kolam"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahKolamScreen(navController)
//                    }
//                }
//            }
//            // EDIT
//            composable("Edit Kolam") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Kelola Kolam"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditKolamScreen(navController)
//                    }
//                }
//            }
//////////////////////////    END KELOLA KOLAM    ///////////////////////
//
//
//////////////////////////    KELOLA PAKAN    ///////////////////////
//            composable("Kelola Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = false
//                        title = ""
//
//                        NavbarTop(navController, back = back, titleScreen = title)
////                        HeaderKelola(navController)
//                        KelolaPakanMain(navController)
//                    }
//                }
//            }
//            composable("Jadwal Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Jadwal Pakan") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        JadwalPakanScreen(navController)
//                    }
//                }
//            }
//            composable("Stok Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                    floatingActionButton = {
//                        FloatingActionButton(
//                            onClick = { navController.navigate("Tambah Stok Pakan") },
//                            modifier = Modifier
//                                .size(60.dp)
//                                .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
//                            containerColor = Color.White
//                        ) {
//                            Image(
//                                painter = painterResource(R.drawable.img_9),
//                                contentDescription = "icon add",
//                                modifier = Modifier
//                                    .size(40.dp),
//                            )
//                        }
//                    },
//                    floatingActionButtonPosition = FabPosition.End,
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        StokPakanScreen(navController)
//                    }
//                }
//            }
//            composable("Hitung Dosis") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Hitung Dosis Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        HeaderKelola(navController)
//                        PenghitungDosisPakan()
//                    }
//                }
//            }
//            // ADD
//            composable("Tambah Jadwal Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahJadwalPakanScreen(navController)
//                    }
//                }
//            }
//            composable("Tambah Stok Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Stok Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        TambahStokPakanScreen(navController)
//                    }
//                }
//            }
//            // EDIT
//            composable("Edit Jadwal Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditJadwalPakanScreen(navController)
//                    }
//                }
//            }
//            composable("Edit Stok Pakan") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Jadwal Pakan"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditStokPakanScreen(navController)
//                    }
//                }
//            }
//////////////////////////    END KELOLA PAKAN    ///////////////////////
//
//
//////////////////////////    PROFILE    ///////////////////////
//            composable("Before Profile") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Profile"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        BeforeProfileScreen(navController)
//                    }
//                }
//            }
//            composable("Profile") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
////                        back = true
////                        title = "Profile"
//
////                        NavbarTop(navController, back = back, titleScreen = title)
//                        ProfileScreen(navController)
//                    }
//                }
//            }
//            composable("Edit Profile") {
//                Scaffold(
//                    bottomBar = { BottomNavigation(navController) },
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .background(Color(0xFF5E7BF9))
//                    ) {
//                        back = true
//                        title = "Profile"
//
//                        NavbarTop(navController, back = back, titleScreen = title)
//                        EditProfileScreen(navController)
//                    }
//                }
//            }
////////////////////////    END PROFILE    ///////////////////////

        }
    }
//}