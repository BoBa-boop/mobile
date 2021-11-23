package com.example.coffee_break

data class guide(val title:String, val image: Int)
data class coffee(val name:String,val price:String, val image: Int)
object List {
    val list = arrayListOf(
        guide("Быстрая\n доставка", R.drawable.delivery),
        guide("Наше кофе из качественных зерен", R.drawable.coffee_bag),
        guide("У нас работают\n профессиноналы", R.drawable.worker)
    )

}
class Skid_coffee{val list = arrayListOf(coffee("Эспрессо","70 руб",R.drawable.espres),
        coffee("Капучино","100 руб",R.drawable.capuch),
        coffee("Латте","60 руб", R.drawable.latte),
        coffee("Мокко", "115 руб", R.drawable.mokko),
        coffee("Горячий шоколад","80 руб",R.drawable.hot_ch),
        coffee("Американо","70 руб", R.drawable.amer)
)

}
