package com.jp.aboutme.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jp.aboutme.R
import com.jp.aboutme.databinding.FragmentSoulBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SoulFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SoulFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSoulBinding>(inflater,
            R.layout.fragment_soul,container,false)
        return binding.root
    }


}