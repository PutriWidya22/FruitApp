package com.putri.fruit.room

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// membuat class LocalDataSource dengan deklarasi appDatabase dan studentDao
class LocalDataSource(context:Context) {
    private val appDatabase = AppDatabase.getDatabase(context)
    private val studentDao = appDatabase.studentDao()

    // untuk mendapatkan data buah dari list data buah
    fun getStudents(callback:(List<StudentEntity>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            callback(studentDao.getAllStudents())
        }
    }

    // membuat fungsi saveStudent untuk menyimpan data buah yang nantinya di proses di studentDao
    fun saveStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.insertStudent(data)
        }
    }

    // membuat fungsi updateStudent untuk memperbarui data buah yang nantinya di proses di studentDao
    fun updateStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.updateStudent(data)
        }
    }

    // membuat fungsi deleteStudent untuk menghapus data buah yang nantinya di proses di studentDao
    fun deleteStudent(data:StudentEntity) {
        CoroutineScope(Dispatchers.Main).launch {
            studentDao.deleteStudent(data)
        }
    }

}