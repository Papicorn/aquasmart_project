package com.aquanusa.aquasmart.condition

import androidx.compose.runtime.Composable

@Composable
fun BackCondition(back: (Boolean) -> Unit, screenNow: (String)) {
    if (
        screenNow == "profile" ||
        screenNow == "kelola_stok_ikan" ||
        screenNow == "kelola_jadwal_panen" ||
        screenNow == "kelola_kematian_ikan" ||
        screenNow == "kelola_jadwal_pakan" ||
        screenNow == "kelola_stok_pakan" ||
        screenNow == "kelola_dosis_pakan" ||
        screenNow == "pengingat" ||
        screenNow == "profile_edit_profile" ||


        screenNow == "tambah_stok_ikan" ||
        screenNow == "tambah_jadwal_panen" ||
        screenNow == "tambah_kematian_ikan" ||
        screenNow == "tambah_kolam" ||
        screenNow == "tambah_jadwal_pakan" ||
        screenNow == "tambah_stok_pakan" ||

        screenNow == "preview_stok_ikan" ||

        screenNow == "edit_kolam"
        ) {
        back(true)
    } else {
        back(false)
    }
}