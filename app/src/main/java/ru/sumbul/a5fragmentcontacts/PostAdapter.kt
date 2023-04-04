package ru.sumbul.a5fragmentcontacts

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

interface OnInteractionListener {

    fun onClick(contact: Contacts) {}
}

class LocationAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Contacts, LocationViewHolder>(LocationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding =
            ContactCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class LocationViewHolder(
    private val binding: contact: Contacts,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(contact: Contacts) {
        binding.apply {
            name.text = contact.title

            itemView.setOnClickListener {
                onInteractionListener.onClick(contact)
            }
        }
    }
}


class LocationDiffCallback : DiffUtil.ItemCallback<Contacts>() {
    override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
        return oldItem == newItem
    }

}