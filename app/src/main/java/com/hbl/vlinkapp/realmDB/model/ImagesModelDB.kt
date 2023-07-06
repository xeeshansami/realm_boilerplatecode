package com.hbl.survey.realmDB.model

import io.realm.RealmObject

open class ImagesModelDB() : RealmObject() {
    var imageName = 0
    var imageUri: String? = null

}