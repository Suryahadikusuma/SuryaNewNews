package com.suryahadi.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suryahadi.newsapp.data.model.Article
import com.suryahadi.newsapp.databinding.ItemArticlePreviewBinding
/**
 * berfungasi untuk menghubungakn data ke tampilan.
 */
class ArticlesAdapter(private val listener: OnItemClickListener): ListAdapter<Article, ArticlesAdapter.ArticleViewHolder>(DiffCallback()) {

    // membuat tampilan untuk mengikat viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ArticleViewHolder(binding)
    }
    // untuk menghubungkan data ke holder
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
    // untuk memuat tampilan pada viewholder yang telah terhubung menggunakan RecyclerView
    inner class ArticleViewHolder(private val binding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        val article = getItem(position)
                        listener.onItemClick(article)
                    }
                }
            }
        }
        // untuk mengambil data yang telah terhubung
        fun bind(article: Article){
            binding.apply {
                Glide.with(itemView)
                    .load(article.urlToImage)
                    .into(ivArticleImage)
                tvDescription.text = article.description
                tvTitle.text = article.title
                tvPublishedAt.text = article.formattedPublishedAt
                tvSource.text = article.source?.name
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(article: Article)
    }


    class DiffCallback : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
}