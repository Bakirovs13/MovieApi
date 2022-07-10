package com.example.movieapi.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.movieapi.R
import com.example.movieapi.adapters.PopularAdapter
import com.example.movieapi.common.Common
import com.example.movieapi.data.model.Movie
import com.example.movieapi.data.retrofit.MovieApi
import com.example.movieapi.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {


    lateinit var binding:FragmentMainBinding
    private lateinit var movieService: MovieApi
    lateinit var adapter : PopularAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PopularAdapter(mutableListOf())
        binding.popularRecycler.adapter = adapter
        initRetrofit()

    }



    private fun initRetrofit() {
        movieService = Common.retrofitService
        binding.popularRecycler.setHasFixedSize(true)
        getAllMovieList()
    }


    private fun getAllMovieList() {

        movieService.getMovieList().enqueue(object :Callback<MutableList<Movie>>{
            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = PopularAdapter(response.body() as MutableList<Movie>)
                binding.popularRecycler.adapter = adapter
                adapter.onItemClick = {movieId ->
                    openFragment(movieId)
                }
            }

            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                Toast.makeText(requireContext(), "failed to download data", Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun openFragment(movie: Movie) {
        val args = Bundle()
        args.putSerializable("IMG", movie.imageurl)
        args.putSerializable("BIO", movie.bio)
        args.putSerializable("NAME", movie.name)
        args.putSerializable("CREATED", movie.createdby)
        args.putSerializable("PRODUCER", movie.publisher)
        val toFragment: Fragment = DetailFragment()
        toFragment.arguments = args
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.my_container, toFragment, "TAG")
            ?.addToBackStack("TAG")?.commit()
    }


}