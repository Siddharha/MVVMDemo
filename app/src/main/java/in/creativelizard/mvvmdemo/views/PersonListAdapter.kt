package `in`.creativelizard.mvvmdemo.views

import `in`.creativelizard.mvvmdemo.models.PersonItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_cell.view.*

class PersonListAdapter (private val list: List<PersonItem>,
                         private val layout: Int) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: PersonListAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


     inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: PersonItem) {
            itemView.tvName.text = item.name
            itemView.tvNumber.text = item.number
        }
    }
}