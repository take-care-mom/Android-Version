package com.example.takecaremom.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.takecaremom.ShopDto
import com.example.takecaremom.TrendingDto

abstract class BaseViewHolder<VB: ViewBinding,T> (protected open val binding: VB):
        RecyclerView.ViewHolder(binding.root){
            abstract fun bindView(item: T)
}

abstract class BaseTrendingViewHolder <VB: ViewBinding>(override val binding: VB):
        BaseViewHolder< VB, TrendingDto>(binding)

abstract class BaseShopViewHolder <VB: ViewBinding>(override val binding: VB):
    BaseViewHolder< VB, ShopDto>(binding)