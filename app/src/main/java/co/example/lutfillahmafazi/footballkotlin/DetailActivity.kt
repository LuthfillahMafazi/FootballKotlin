package co.example.lutfillahmafazi.footballkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var namaClub = intent.getStringExtra("nama")
        var detailClub = intent.getStringExtra("detail")
        var gambarClub = intent.getIntExtra("gambar", 0)

        txtNamaclubDetail.text = namaClub
        txtDetailClub.text = detailClub
        Glide.with(this).load(gambarClub).into(imgLogoClubDetail)
    }
}
