package com.example.movieapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movieapi.R
import com.example.movieapi.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.combine


class DetailFragment : Fragment() {

    lateinit var binding:FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        var mBundle: Bundle? = Bundle()
        mBundle = arguments
       var img =  mBundle!!.getString("IMG")
       var bio =  mBundle!!.getString("BIO")
       var name =  mBundle!!.getString("NAME")
       var created =  mBundle!!.getString("CREATED")
       var producer =  mBundle!!.getString("PRODUCER")
        Picasso.get().load(img).into(binding.detailImg)
        binding.bioDetail.text = bio
        binding.nameDetail.text = name
        binding.producerDetail.text = producer
        binding.creattedDetail.text = created

    }
}