package com.example.addtextviewprogrammatically

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = getResponse()
        val scrollView = findViewById<ScrollView>(R.id.scroll_view)
        val table = TableLayout(this)
        val tableLayoutParam = TableLayout.LayoutParams(
            TableLayout.LayoutParams.WRAP_CONTENT,
            TableLayout.LayoutParams.WRAP_CONTENT
        )
        table.layoutParams = tableLayoutParam
        val horizontalList = response.data?.horizontalArray



        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(10,10,10,10)

        val textViewParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        textViewParams.gravity = TextView.TEXT_ALIGNMENT_CENTER


        val tableRow = TableRow(this)
        horizontalList?.let {
            for (value: Response.Data.Values in horizontalList) {

                val itemHorizontal = LinearLayout(this)
                itemHorizontal.orientation = LinearLayout.VERTICAL
                itemHorizontal.layoutParams = layoutParams

                val textName = TextView(this)
                val textValue = TextView(this)

                textName.layoutParams = textViewParams
                textValue.layoutParams = textViewParams


                textName.text = value.name
                textValue.text = value.value.toString()
                itemHorizontal.addView(textName)
                itemHorizontal.addView(textValue)
                tableRow.addView(itemHorizontal)
            }
        }

        table.addView(tableRow)
        scrollView.addView(table)
    }

    private fun getResponse(): Response {
        var response = Response()
        try {
            response = GsonBuilder().create().fromJson(answer(), Response::class.java)
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
        return response
    }

    private fun answer(): String {
        return "{\"front\":{\"obj\":\"strip\",\"method\":\"request\"},\"data\":{\"hor\":[{\"name\":\"hor_name_1\",\"value\":31.629},{\"name\":\"hor_name_2\",\"value\":-186.39},{\"name\":\"hor_name_3\",\"value\":63.911},{\"name\":\"hor_name_4\",\"value\":-165.974},{\"name\":\"hor_name_5\",\"value\":466.349},{\"name\":\"hor_name_6\",\"value\":-413.373},{\"name\":\"hor_name_7\",\"value\":-469.57},{\"name\":\"hor_name_8\",\"value\":-251.55},{\"name\":\"hor_name_9\",\"value\":260.175},{\"name\":\"hor_name_10\",\"value\":52.463}],\"vert\":[{\"name\":\"vert_name_1\",\"value\":229.266},{\"name\":\"vert_name_2\",\"value\":480.363},{\"name\":\"vert_name_3\",\"value\":140.796},{\"name\":\"vert_name_4\",\"value\":-223.89},{\"name\":\"vert_name_5\",\"value\":-392.963},{\"name\":\"vert_name_6\",\"value\":7.982},{\"name\":\"vert_name_7\",\"value\":-489.696},{\"name\":\"vert_name_8\",\"value\":-408.587},{\"name\":\"vert_name_9\",\"value\":-262.097},{\"name\":\"vert_name_10\",\"value\":-384.031}]},\"error\":false,\"msg\":[],\"user\":{\"packedEmplId\":\"H4sIAAAAAAAAADM0NDQFAO4MlNwEAAAA\\n\",\"packedEmplIdMA\":\"H4sIAAAAAAAAADM3NTa2BADpLZWfBQAAAA==\\n\",\"regId\":\"263A73AAAAA8E92C5920130ECE3CDA80D5AC21FAACEE98D930BEBE81185DD3E9\",\"appVersion\":\"6.6.9\",\"fcmToken\":\"ew8qJB26QTqSwCjXqcyPfL:APA91bHFVIGvVmLy8FHNET-x4Wk5QPhLiVOwGTMTWDR3-MSHI5pfhuNuJ92d-_oZ5A-_rNYsVuAS9DWfPFJge8gnOUMeC65m2J7Rfy83xN4fshZf_DsnGJWfqCX_MhqEDEIqcWlmVO9O\"}}"
    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val tableParams = TableLayout.LayoutParams(
//            TableLayout.LayoutParams.WRAP_CONTENT,
//            TableLayout.LayoutParams.WRAP_CONTENT
//        )
//        val rowParams: TableRow.LayoutParams =
//            TableRow.LayoutParams(
//                TableRow.LayoutParams.WRAP_CONTENT,
//                TableRow.LayoutParams.WRAP_CONTENT
//            )
//
//        val tableLayout = TableLayout(this)
//        tableLayout.layoutParams =
//            LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            ) // assuming the parent view is a LinearLayout
//
//
//
//        val table = TableLayout(this)
//        for (j in 1..3) {
//            val tableRow = TableRow(this)
//            tableRow.layoutParams = tableParams // TableLayout is the parent view
//            for (i in 1..10) {
//                val textView = TextView(this)
//                textView.layoutParams = rowParams // TableRow is the parent view
//                textView.text = "Programmatically # $i"
//                tableRow.addView(textView)
//            }
//
//            table.addView(tableRow)
//        }
//        val horizontalScrollView:HorizontalScrollView = findViewById(R.id.scroll_view)
//        horizontalScrollView.addView(table)
//    }
}