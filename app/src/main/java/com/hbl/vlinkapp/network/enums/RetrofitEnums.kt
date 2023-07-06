package com.hbl.hblaccountopeningapp.network.enums

import com.hbl.vlinkapp.utils.Config


enum class RetrofitEnums(var url: String) {
    URL_MAPS(Config.BASE_URL_MAP),
    URL_HBL(
        Config.BASE_URL_MAP
    ),
    URL_KONNECT(Config.BASE_URL_MAP);
}