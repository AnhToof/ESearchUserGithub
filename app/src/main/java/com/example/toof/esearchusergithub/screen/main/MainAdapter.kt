package com.example.toof.esearchusergithub.screen.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.toof.esearchusergithub.R
import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.utils.OnItemRecyclerViewClickListener

class MainAdapter(context: Context, listener: OnItemRecyclerViewClickListener<User>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val mContext = context
    private val mList: ArrayList<User> = ArrayList()
    private val mListener: OnItemRecyclerViewClickListener<User> = listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_user, p0, false),
            mList,
            mListener
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindViewData(mList[p1])
    }

    fun updateData(list: ArrayList<User>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(
        view: View,
        list: ArrayList<User>,
        listener: OnItemRecyclerViewClickListener<User>
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val mList: ArrayList<User> = list
        private val mListener: OnItemRecyclerViewClickListener<User> = listener
        private val mImageView: ImageView = view.findViewById(R.id.image_view)
        private val mTextViewId: TextView = view.findViewById(R.id.text_id)
        private val mTextViewLogin: TextView = view.findViewById(R.id.text_login)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindViewData(user: User) {
            mTextViewId.text = user.id
            mTextViewLogin.text = user.login
            Glide.with(itemView)
                .load(user.avatar_url)
                .into(mImageView)
        }

        override fun onClick(v: View?) {
            mListener.onItemClickListener(mList[adapterPosition])
        }

    }
}