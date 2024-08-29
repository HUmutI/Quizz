package com.example.quizz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.quizz.databinding.RecyclerRowBinding

class TopicAdapter(val topicList : ArrayList<Question>) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    class  TopicViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.binding.textView.text = topicList[position].topicName
        holder.binding.imageView3.setImageResource(topicList[position].topicImage)
        holder.itemView.setOnClickListener {
            clicked_topic(it,position)
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    fun clicked_topic(view: View,position: Int){
        val action = quizTopicFragmentDirections.actionQuizTopicFragmentToShowQuestionFragment(topicList[position])
        Navigation.findNavController(view).navigate(action)
    }

}