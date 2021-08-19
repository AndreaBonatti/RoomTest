package com.example.roomtest.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtest.data.User
import com.example.roomtest.databinding.CustomRowBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    class MyViewHolder(val binding: CustomRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CustomRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.firstNameTxt.text = currentItem.firstName
        holder.binding.lastNameTxt.text = currentItem.lastName
        holder.binding.ageTxt.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
}