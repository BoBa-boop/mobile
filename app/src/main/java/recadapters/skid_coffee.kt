package recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.R
import com.example.coffee_break.coffee

class skid_coffee (val context: Context, val list:ArrayList<coffee>) : RecyclerView.Adapter<skid_coffee.MyVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): skid_coffee.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.skid_cof,parent,false)
        return MyVH(root)
    }
class MyVH(itemView: View): RecyclerView.ViewHolder(itemView){
    val name:TextView = itemView.findViewById(R.id.name_coffee_txt)
    val price:TextView = itemView.findViewById(R.id.txt_price)
    val image:ImageView = itemView.findViewById(R.id.img_coffee)
}
    override fun onBindViewHolder(holder: skid_coffee.MyVH, position: Int) {
        holder.name.setText(list[position].name)
        holder.price.setText(list[position].price)
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}