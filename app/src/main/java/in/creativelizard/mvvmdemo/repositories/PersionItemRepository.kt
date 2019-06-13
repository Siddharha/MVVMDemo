package `in`.creativelizard.mvvmdemo.repositories

import `in`.creativelizard.mvvmdemo.models.PersonItem
import androidx.lifecycle.MutableLiveData

class PersionItemRepository {
     private var dataSet : ArrayList<PersonItem> = ArrayList()


companion object{
    private val instance : PersionItemRepository?=null
    val getInstance: () -> PersionItemRepository = {

        if(instance == null){
            PersionItemRepository()
        }
        else{
            instance
        }
    }
}


    val getPersionList : () -> MutableLiveData<List<PersonItem>> = {
        val data = MutableLiveData<List<PersonItem>>()
        data.value = getDataFromLocal()
        data
    }

    private val getDataFromLocal : () -> ArrayList<PersonItem> = {
        for (i in 0 until 10){
            val p = PersonItem("NAME - $i","NUMBER - $i")
            dataSet.add(p)
        }
        dataSet

    }
}