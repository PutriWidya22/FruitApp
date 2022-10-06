package com.putri.fruit

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.putri.fruit.room.LocalDataSource
import com.putri.fruit.room.StudentEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// membuat class MainViewModel yang mengextends ViewModel dengan deklarasi variabel students yang
// menampilkan list entitas student atau nantinya akan menampilkan list data buah
class MainViewModel : ViewModel() {
    val students = MutableLiveData<List<StudentEntity>>()

    // menampilkan hasil
    fun getStudent(context: Context) {
        val localDataSource = LocalDataSource(context)
        localDataSource.getStudents { result ->
            students.postValue(result)
        }
    }
}