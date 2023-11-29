package com.example.takecaremom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.takecaremom.base.BaseTrendingViewHolder
import com.example.takecaremom.databinding.TrendingItemBinding


class TrendingAdapter:ListAdapter<TrendingDto,BaseTrendingViewHolder<*>>(TrendingDiffUtils()) {

    class TrendingDiffUtils:DiffUtil.ItemCallback<TrendingDto>(){
        override fun areItemsTheSame(oldItem: TrendingDto, newItem: TrendingDto): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: TrendingDto, newItem: TrendingDto): Boolean {
            return oldItem==newItem
        }
    }

    class TrendingViewHoler(binding: TrendingItemBinding): BaseTrendingViewHolder<TrendingItemBinding>(binding){
        override fun bindView(item: TrendingDto) {
            with(binding){
                image.setImageResource(item.image)
                title.text=itemView.context.getString(item.name)
                shopLogo.setImageResource(item.shopLogo)
                shopName.text=itemView.context.getString(item.shopName)
                date.text=itemView.context.getString(item.date)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseTrendingViewHolder<*> {
        return TrendingViewHoler(
            TrendingItemBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseTrendingViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}

data class TrendingDto(
    val id:Int,
    @StringRes
    val name:Int,
    val shopName:Int,
    val date:Int,
    @DrawableRes
    val image:Int,
    val shopLogo:Int,

)