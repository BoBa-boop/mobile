package com.example.coffee_break

data class guide(val title:String, val image: Int)

object List {
    val list = arrayListOf(
        guide("Быстрая доставка", R.drawable.delivery),
        guide("Наше кофе из качественных зерен", R.drawable.coffee_bag),
        guide("У нас работают профессиноналы", R.drawable.worker)
    )


}
