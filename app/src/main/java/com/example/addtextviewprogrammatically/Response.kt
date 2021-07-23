package com.example.addtextviewprogrammatically

import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("data")
    val data: Data? = null
    @SerializedName("error")
    val isError = false
    @SerializedName("msg")
    val errorsList: List<Msg> = emptyList()

    class Data {
        @SerializedName("hor")
        val horizontalArray: List<Values> = emptyList()

        @SerializedName("vert")
        val verticalArray: List<Values> = emptyList()

        data class Values(
            @SerializedName("name") val name: String?,
            @SerializedName("value") val value: Double?
        )
    }

    data class Msg(val id: String, val name: String)
}