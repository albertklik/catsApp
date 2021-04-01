package com.klik.catsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klik.catsapp.adapters.CatsImageRecyclerViewAdapter
import com.klik.catsapp.api.RetrofitInitializer
import com.klik.catsapp.models.CatsSearchRequest
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = catsRecyclerView;
        loadCatsImages()
    }



    private fun generateCatsImages(): List<CatsSearchRequest.CatsImage>
    {
        val catsImages : MutableList<CatsSearchRequest.CatsImage> = mutableListOf()
        while (catsImages.size < 40)
        {
            catsImages.add(CatsSearchRequest.CatsImage("2bvab7y", "gatinho" + (catsImages.size + 1)))
        }
        return catsImages
    }

    private fun loadRecyclerView(data : List<CatsSearchRequest.CatsImage>) {
        recyclerView.adapter = CatsImageRecyclerViewAdapter(data)
        val layoutManager = GridLayoutManager(this@MainActivity,4)
        recyclerView.layoutManager = layoutManager
    }

    private fun loadCatsImages() {
        val call = RetrofitInitializer().catsImageService().getCatsImages()
        call.enqueue(object : Callback<CatsSearchRequest.Request>
        {
            override fun onFailure(call: Call<CatsSearchRequest.Request>, t: Throwable)
            {
                Toast.makeText(this@MainActivity,"Erro ao carregar as fotos de gatinhos",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CatsSearchRequest.Request>, response: Response<CatsSearchRequest.Request?>?)
            {
                response?.body()?.let {
                    loadRecyclerView(it.data)
                }
            }
        })
    }
}