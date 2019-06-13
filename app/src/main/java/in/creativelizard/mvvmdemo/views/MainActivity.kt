package `in`.creativelizard.mvvmdemo.views

import `in`.creativelizard.mvvmdemo.R
import `in`.creativelizard.mvvmdemo.models.PersonItem
import `in`.creativelizard.mvvmdemo.repositories.PersionItemRepository
import `in`.creativelizard.mvvmdemo.viewModels.MainActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PersonListAdapter
    lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        setuplist()
    }

    var initialize = {

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        adapter = PersonListAdapter(mainActivityViewModel.getPersonItems().value!!,R.layout.person_cell)
        rlPersons.layoutManager = layoutManager
        rlPersons.adapter = adapter
    }
    val setuplist = {

        mainActivityViewModel.getPersonItems().observe(this, Observer {
            adapter.notifyDataSetChanged()
        })


    }
}
