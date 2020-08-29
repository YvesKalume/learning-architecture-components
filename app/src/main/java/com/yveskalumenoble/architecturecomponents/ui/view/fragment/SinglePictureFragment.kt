package com.yveskalumenoble.architecturecomponents.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.yveskalumenoble.architecturecomponents.R
import com.yveskalumenoble.architecturecomponents.databinding.FragmentSinglePictureBinding

/**
 * A simple [Fragment] subclass.
 */
class SinglePictureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSinglePictureBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_single_picture,
            container,false)
        val args= SinglePictureFragmentArgs.fromBundle(requireArguments())
        binding.picture = args.picture

        return binding.root
    }

}
