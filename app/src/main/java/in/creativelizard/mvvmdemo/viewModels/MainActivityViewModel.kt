package `in`.creativelizard.mvvmdemo.viewModels

import `in`.creativelizard.mvvmdemo.models.PersonItem
import `in`.creativelizard.mvvmdemo.repositories.PersionItemRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
     var persons : MutableLiveData<List<PersonItem>>
    init {
        val preItemRepository = PersionItemRepository.getInstance()
        persons = preItemRepository.getPersionList()
    }


    val getPersonItems : () ->LiveData<List<PersonItem>> = { persons }
}