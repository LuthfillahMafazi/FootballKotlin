package co.example.lutfillahmafazi.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaClub = resources.getStringArray(R.array.club_name)
        val detailClub = resources.getStringArray(R.array.club_detail)
        val gambarClub = resources.obtainTypedArray(R.array.club_image)

        for (i in namaClub.indices){
            items.add(Item(namaClub[i], detailClub[i], gambarClub.getResourceId(i, 0)))
        }

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = RecycleAdapter(this, items){
            startActivity<DetailActivity>("nama" to it.nama, "detail" to it.detail, "gambar" to it.gambar)
        }
    }
}
