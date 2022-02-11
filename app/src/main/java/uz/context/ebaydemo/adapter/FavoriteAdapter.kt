package uz.context.ebaydemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.ebaydemo.R
import uz.context.ebaydemo.model.Favorite

class FavoriteAdapter(context: Context, private val items: ArrayList<Favorite>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_favorite, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                imageView.setImageResource(item.image)
                title.text = item.title
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.iv_image)
        val title: TextView = view.findViewById(R.id.tv_title)
    }
}