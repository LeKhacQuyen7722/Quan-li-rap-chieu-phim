package com.example.cinema.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.adapter.CategoryAdapter.CatogoryViewHolder
import com.example.cinema.databinding.ItemCategoryBinding
import com.example.cinema.model.Category
import com.example.cinema.util.GlideUtils

class CategoryAdapter(private val mListCategory: List<Category>?,
                      private val iManagerCategoryListener: IManagerCategoryListener) : RecyclerView.Adapter<CatogoryViewHolder>() {
    interface IManagerCategoryListener {
        fun clickItemCategory(category: Category?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatogoryViewHolder {
        val mItemCategoryBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatogoryViewHolder(mItemCategoryBinding)
    }

    override fun onBindViewHolder(holder: CatogoryViewHolder, position: Int) {
        val category = mListCategory!![position]
        GlideUtils.loadUrl(category.image, holder.mItemCategoryBinding.imgCategory)
        holder.mItemCategoryBinding.tvCategoryName.text = category.name
        holder.mItemCategoryBinding.layoutItem.setOnClickListener { iManagerCategoryListener.clickItemCategory(category) }
    }

    override fun getItemCount(): Int {
        return mListCategory?.size ?: 0
    }

    class CatogoryViewHolder(val mItemCategoryBinding: ItemCategoryBinding) : RecyclerView.ViewHolder(mItemCategoryBinding.root)
}