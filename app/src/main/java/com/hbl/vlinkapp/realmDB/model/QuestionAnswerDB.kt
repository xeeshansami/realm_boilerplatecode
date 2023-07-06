package com.hbl.survey.realmDB.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

open class QuestionAnswerDB() :RealmObject() {

    var userID = ""

    var token = ""

    var surveyID = ""

    var endDateTime = ""

    var latitude = ""

    var longitude = ""

    var surveyName = ""

    var surveyCategoryName = ""

    var answerTime = ""

    var comment = ""

    var answerValue = ""

    var imagesModel = RealmList<ImagesModelDB>()

    @SerializedName("answerTypeID")
    var answerTypeID: String? = null

    @SerializedName("answerTypeName")
    var answerTypeName: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("isCommentMandatory")
    var isCommentMandatory: String? = null

    @SerializedName("isImageMandatory")
    var isImageMandatory: String? = null

    @SerializedName("optionSetID")
    var optionSetID: String? = null

    @SerializedName("options")
    var options: RealmList<QuesAnswerOptionDB>? = null

    @SerializedName("questionCategoryID")
    var questionCategoryID: String? = null

    @SerializedName("questionCategoryName")
    var questionCategoryName: String? = null

    @SerializedName("questionID")
    var questionID: String? = null

    @SerializedName("questionTitle")
    var questionTitle: String? = null

    @SerializedName("surveyCategoryID")
    var surveyCategoryID: String? = null

}