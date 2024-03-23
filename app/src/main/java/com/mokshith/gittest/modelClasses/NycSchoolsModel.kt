package com.mokshith.gittest.modelClasses

import com.google.gson.annotations.SerializedName

data class NycSchoolsModel(
    val dbn: String?,
    @SerializedName("school_name")
    val schoolName: String?,
    @SerializedName("overview_paragraph")
    val overviewParagraph: String?,
)
