package recadapters

import com.example.practich.R

data class feel(val image:Int, val name_feel:String)
class MyFeel{val list = arrayListOf(feel(R.drawable.yin_yang,"Спокойным"),
    feel(R.drawable.tris,"Рассабленным"),
    feel(R.drawable.buda,"Сосредоточенным"),
    feel(R.drawable.spir,"Взволнованым")
)
}