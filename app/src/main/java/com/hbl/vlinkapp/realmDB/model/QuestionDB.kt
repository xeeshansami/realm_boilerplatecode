package com.hbl.survey.realmDB.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class QuestionDB() : RealmObject() {

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

//    @SerializedName("options")
//    var options: ArrayList<QuesAnswerOptionDB>? = null

    @SerializedName("questionCategoryID")
    var questionCategoryID: String? = null

    @SerializedName("questionCategoryName")
    var questionCategoryName: String? = null

    @PrimaryKey
    @SerializedName("questionID")
    var questionID: String? = null

    @SerializedName("questionTitle")
    var questionTitle: String? = null

    @SerializedName("surveyCategoryID")
    var surveyCategoryID: String? = null

}