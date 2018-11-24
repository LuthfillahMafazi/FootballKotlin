package co.example.lutfillahmafazi.footballkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.example.lutfillahmafazi.footballkotlin.R.id.imgLogoClubDetail
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_club.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick


// TODO Class RecycleAdapter mewariskan Recycle View
class RecycleAdapter (val context: Context, val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    // TODO Mengimplementasikan Method dari RecycleView
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_club, viewGroup, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items[position], listener)

    }

    // TODO membuat class ViewHolder untuk berinteraksi dengan tampilan
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val namaClub = view.txtNamaclub
        val gambarLogoClub = view.imgLogoClub

        fun bindItem (item: Item, listener: (Item) -> Unit) {
            namaClub.text = item.nama
            Glide.with(itemView.context).load(item.gambar).into(gambarLogoClub)
            itemView.onClick {
                listener(item)
            }

        }
    }

}