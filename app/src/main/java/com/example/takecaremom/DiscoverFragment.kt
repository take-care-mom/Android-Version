package com.example.takecaremom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.takecaremom.databinding.FragmentDiscoverBinding
import com.example.takecaremom.databinding.FragmentHomeBinding


class DiscoverFragment : Fragment() {
    private lateinit var binding: FragmentDiscoverBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDiscoverBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shopAdapter=ShopAdapter()

        with(binding) {
            shopView.adapter = shopAdapter
            shopView.layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false
                )

        }
        shopAdapter.submitList(getTrendingList())
    }

    private fun getTrendingList():List<ShopDto>{
        return listOf(
            ShopDto(
                1,
                R.string.shop_name1,
                R.drawable.logo_meloman,
            ),
            ShopDto(
                2,
                R.string.shop_name2,
                R.drawable.logo_alpak
            )
        )
    }
}
