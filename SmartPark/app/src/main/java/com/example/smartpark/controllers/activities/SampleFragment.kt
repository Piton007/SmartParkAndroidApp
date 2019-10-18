package com.example.smartpark.controllers.activities

import android.content.Context
import android.net.Uri
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.smartpark.R
import com.example.smartpark.databinding.FragmentSampleBinding



class SampleFragment : Fragment() {
    // TODO: Rename and change types of parameters



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentSampleBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_sample, container, false)

        return binding.root
    }


}
