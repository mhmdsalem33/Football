package com.sa.football.presention.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sa.football.databinding.ItemCompetitionBinding
import com.sa.football.domain.models.CompetitionModel
import com.sa.football.presention.extentions.loadImage

class CompetitionAdapter : RecyclerView.Adapter<CompetitionAdapter.ViewHolder>() {


    private val diffUtilCallback = object : DiffUtil.ItemCallback<CompetitionModel>() {
        override fun areItemsTheSame(
            oldItem: CompetitionModel,
            newItem: CompetitionModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CompetitionModel,
            newItem: CompetitionModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtilCallback)


    class ViewHolder(val binding: ItemCompetitionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCompetitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val competition = differ.currentList[position]


        holder.binding.apply {
            ivEmblem.loadImage(competition.emblem)
            tvCompetitionName.text = competition.name
            tvAreaName.text = competition.area.name
        }

    }

    override fun getItemCount() = differ.currentList.size

}