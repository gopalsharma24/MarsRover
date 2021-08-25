package com.example.mars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mars.adapter.RoverAdapter
import com.example.mars.model.Photos
import com.example.mars.network.RetroService
import kotlinx.android.synthetic.main.fragment_rover.*
import okhttp3.Call
import okhttp3.Callback
import retrofit2.Response


class RoverFragment : Fragment(R.layout.fragment_rover) {

    lateinit var roverAdapter: RoverAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    private fun getData() {
        val photos = RetroService.retroInstance.getAPIData(1000)
        photos.enqueue(object : retrofit2.Callback<Photos> {
            override fun onResponse(call: retrofit2.Call<Photos>, response: Response<Photos>) {

                val photos = response.body()
                if (photos != null) {
                    Log.d("TEST", photos.toString())
                    roverAdapter = activity?.let { RoverAdapter(it, photos.photos) }!!
                    roverRecycler.adapter = roverAdapter
                    roverRecycler.layoutManager = GridLayoutManager(context, 2)
                }
            }

            override fun onFailure(call: retrofit2.Call<Photos>, t: Throwable) {
                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show()

            }
        })


    }
}