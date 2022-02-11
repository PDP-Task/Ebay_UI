package uz.context.ebaydemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.context.ebaydemo.R
import uz.context.ebaydemo.model.Deals

class DealsAdapter(private val dealsList: ArrayList<Deals>) :
    RecyclerView.Adapter<DealsAdapter.DealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.deals_item_layout, parent, false)
        return DealViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        val deal = dealsList[position]

        holder.apply {
            imageView.setImageResource(deal.image)
            title.text = deal.title
            dealsPrice.text = "$${deal.price}"
        }
    }

    override fun getItemCount(): Int {
        return dealsList.size
    }

    inner class DealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ear_phone_image)
        val title: TextView = view.findViewById(R.id.deals_title)
        val dealsPrice: TextView = view.findViewById(R.id.deals_price)
    }
}