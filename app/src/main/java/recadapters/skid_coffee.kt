package recadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.R
import com.example.coffee_break.coffee

class skid_coffee (val context: Context, val list:ArrayList<coffee>) : RecyclerView.Adapter<skid_coffee.MyVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): skid_coffee.MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.)
    }
class MyVH(itemView: View): RecyclerView.ViewHolder(itemView){

}
    override fun onBindViewHolder(holder: skid_coffee.MyVH, position: Int) {
        holder.name.setImageResource(list[position].image)
        holder.te
    }

    override fun getItemCount(): Int {
        return list.size
    }
}