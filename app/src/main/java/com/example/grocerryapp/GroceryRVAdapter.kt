package com.example.grocerryapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    private val groceryItemClickInterface: GroceryItemClickInterface)
    : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>()
{

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val quantityTV: TextView = itemView.findViewById<TextView>(R.id.idTVQuantity)
        val rateTV: TextView = itemView.findViewById<TextView>(R.id.idTVRate)
        val amountTV: TextView = itemView.findViewById<TextView>(R.id.idTVTotalAmt)
        val deleteTV: ImageView = itemView.findViewById<ImageView>(R.id.idIVDelete)
        val nameTV: TextView = itemView.findViewById<TextView>(R.id.idTVItemName)

    }


    interface GroceryItemClickInterface{
        fun onItemClick(groceryItems: GroceryItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val View =
            LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_items, parent, false)
        return GroceryViewHolder(View)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
    holder.nameTV.text = list[position].itemName
    holder.quantityTV.text = list[position].itemQuantity.toString()
    holder.rateTV.text = "Rs. "+ list[position].itemPrice.toString()
    val itemTotal: Int = list[position].itemPrice * list[position].itemQuantity
    holder.amountTV.text = "Rs. $itemTotal"
    holder.deleteTV.setOnClickListener {
        groceryItemClickInterface.onItemClick(list[position])
    }
}

    override fun getItemCount(): Int
    {
        return list.size
    }

}