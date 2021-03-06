package com.bartex.radditless5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bartex.radditless5.entity.Children

class RedditPageAdapter
    : PagedListAdapter<Children, RedditViewHolder>(POST_COMPARATOR) {

        companion object{
               val POST_COMPARATOR = object : DiffUtil.ItemCallback<Children>() {
                override fun areContentsTheSame(oldItem: Children, newItem: Children): Boolean =
                    oldItem == newItem

                override fun areItemsTheSame(oldItem: Children, newItem: Children): Boolean =
                    oldItem === newItem
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
            return RedditViewHolder(view)
        }

        override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
            val repoItem = getItem(position)
            holder.bind(repoItem)
        }
    }

    class RedditViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val ivComunity = view.findViewById<TextView>(R.id.tvLessonHw_add)
        private val tvAuthor = view.findViewById<TextView>(R.id.tv_teacher_add)
        private val tvMessage = view.findViewById<TextView>(R.id.tvHomeworkHw_add)
        private val tvUpvote = view.findViewById<TextView>(R.id.tvUpvote)
        private val tvComments = view.findViewById<TextView>(R.id.tvComments)
        private val tvAwards = view.findViewById<TextView>(R.id.tvAwards)

        fun bind(children: Children?) {
            if (children != null) {
                ivComunity.text = children.data?.subreddit_name_prefixed
                tvAuthor.text = children.data?.author
                tvMessage.text = children.data?.title
                tvUpvote.text = children.data?.ups.toString()
                tvComments.text = children.data?.num_comments.toString()
                tvAwards.text = children.data?.total_awards_received.toString()
            }
        }
    }