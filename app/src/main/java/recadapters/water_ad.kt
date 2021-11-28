package recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.R
import com.example.coffee_break.water

class water_ad(val context: Context, val list:ArrayList<water>) : RecyclerView.Adapter<water_ad.MyVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): water_ad.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.skid_cof,parent,false)
        return MyVH(root)
    }
    class MyVH(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.findViewById(R.id.name_coffee_txt)
        val price: TextView = itemView.findViewById(R.id.txt_price)
        val image: ImageView = itemView.findViewById(R.id.img_coffee)
    }
    override fun onBindViewHolder(holder: water_ad.MyVH, position: Int) {
        holder.name.setText(list[position].name)
        holder.price.setText(list[position].price)
        holder.image.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}