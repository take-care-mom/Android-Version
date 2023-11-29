package com.example.takecaremom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.takecaremom.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trendingAdapter=TrendingAdapter()
        with(binding){

            trendingView.adapter=trendingAdapter
            trendingView.layoutManager=
                LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)

        }
        trendingAdapter.submitList(getTrendingList())
    }

    private fun getTrendingList():List<TrendingDto>{
        return listOf(
            TrendingDto(
                1,
                R.string.toys_name1,
                R.string.shop_name1,
                R.string.date1,
                R.drawable.coverimg1,
                R.drawable.logo_meloman

            ),
            TrendingDto(
                2,
            R.string.toys_name2,
            R.string.shop_name2,
            R.string.date2,
            R.drawable.coverimg2,
            R.drawable.logo_alpak

        )
        )
    }
}