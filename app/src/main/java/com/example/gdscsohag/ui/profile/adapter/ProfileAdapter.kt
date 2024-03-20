package com.example.gdscsohag.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.gdscsohag.R
import com.example.gdscsohag.databinding.ChildProfileFirstTraineeBinding
import com.example.gdscsohag.databinding.ChildProfileRestOfTraineeBinding
import com.example.gdscsohag.ui.base.BaseAdapter
import com.example.gdscsohag.ui.profile.ProfileUiState

class ProfileAdapter(
    val state: ProfileUiState
) : BaseAdapter<ProfileUiState>() {
    override val layoutId = R.layout.fragment_profile

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            FIRST_ITEM -> FirstTraineeViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_profile_first_trainee,
                    parent,
                    false
                )
            )

            else -> RestOfTraineeViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_profile_rest_of_trainee,
                    parent,
                    false
                )
            )
        }
    }

    override fun bindData(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is FirstTraineeViewHolder -> bindFirstTrainee(holder)
            is RestOfTraineeViewHolder -> bindRestOfTrainee(holder)
        }
    }

    private fun bindFirstTrainee(holder: FirstTraineeViewHolder) {
        (holder.binding as ChildProfileFirstTraineeBinding).apply {
            if (state.trainees.isNotEmpty())
                item = state.trainees.first()
        }
    }


    private fun bindRestOfTrainee(holder: RestOfTraineeViewHolder) {
        (holder.binding as ChildProfileRestOfTraineeBinding).apply {
            if (this@ProfileAdapter.state.trainees.size >= 2) {
                val newList = this@ProfileAdapter.state.trainees.toMutableList().apply { removeFirst() }
              //  trainees = newList
            }
            restOfTraineeRecycler.adapter = RestOfTraineeAdapter()
        }
    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position
    inner class FirstTraineeViewHolder(binding: ChildProfileFirstTraineeBinding) :
        BaseViewHolder(binding)

    inner class RestOfTraineeViewHolder(binding: ChildProfileRestOfTraineeBinding) :
        BaseViewHolder(binding)

    companion object {
        const val ITEMS_COUNT = 2
        const val FIRST_ITEM = 0
    }
}