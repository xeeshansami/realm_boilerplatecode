package com.hbl.survey.realmDB.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


open class QuesAnswerOptionDB:RealmObject(
) {

    @SerializedName("optionID")
    var optionID = ""

    @SerializedName("optionSetID")
    var optionSetID = ""

    @SerializedName("optionValue")
    var optionValue = ""
}