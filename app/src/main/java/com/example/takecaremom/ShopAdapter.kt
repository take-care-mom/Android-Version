package com.example.takecaremom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.takecaremom.base.BaseShopViewHolder
import com.example.takecaremom.base.BaseTrendingViewHolder
import com.example.takecaremom.databinding.ShopItemBinding


class ShopAdapter : ListAdapter<ShopDto, BaseShopViewHolder<*>>(ShopDiffUtils()) {

    class ShopDiffUtils: DiffUtil.ItemCallback<ShopDto>(){
        override fun areItemsTheSame(oldItem: ShopDto, newItem: ShopDto): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ShopDto, newItem: ShopDto): Boolean {
            return oldItem==newItem
        }
    }

    class ShopViewHoler(binding: ShopItemBinding): BaseShopViewHolder<ShopItemBinding>(binding){
        override fun bindView(item: ShopDto) {
            with(binding){
                image.setImageResource(item.shopLogo)
                title.text=itemView.context.getString(item.shopName)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseShopViewHolder<*> {
        return ShopViewHoler(
            ShopItemBinding.inflate(
                LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseShopViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}
data class ShopDto(
    val id:Int,
    @StringRes
    val shopName:Int,
    @DrawableRes
    val shopLogo:Int,

    )