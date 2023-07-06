package com.hbl.survey.realmDB.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class SurveyEventDataDB() : RealmObject() {

    var isStarted=0

    var isUploaded=false

    @SerializedName("branchCode")
    var branchCode = ""

    @SerializedName("description")
    var description = ""

    @SerializedName("endDateTime")
    var endDateTime = ""

    @SerializedName("officerID")
    var officerID = ""

    @SerializedName("startDateTime")
    var startDateTime = ""

    @SerializedName("surveyCategoryID")
    var surveyCategoryID = ""

    @SerializedName("surveyCategoryName")
    var surveyCategoryName = ""

    @PrimaryKey
    @SerializedName("surveyID")
    var surveyID = ""

    @SerializedName("surveyName")
    var surveyName = ""

    @SerializedName("surveyStatus")
    var surveyStatus = ""

}