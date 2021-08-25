package com.example.mars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        detailText.text = intent.getStringExtra("roverId")
        val detailImg = intent.getIntExtra("roverImg",0)
        detailImage.setImageResource(detailImg)

        //val detailId: TextView = findViewById(R.id.tvRoverId)

        // val bundle:Bundle?=intent.extras

        //val detailTxt = bundle!!.getString("roverId")

        //detailId.text = detailTxt
    }
}