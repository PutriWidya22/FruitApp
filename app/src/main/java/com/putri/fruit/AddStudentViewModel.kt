package com.putri.fruit

import android.content.Context
import androidx.lifecycle.ViewModel
import com.putri.fruit.room.LocalDataSource
import com.putri.fruit.room.StudentEntity

// membuat class AddStudentViewModel yang mengextends dari ViewModel
class AddStudentViewModel : ViewModel() {

    // terdapat fungsi addStudent dengan deklarasi nama,dan kelas (stok) menggunakan tipe data string.
    // jika sukses maka akan bertipe data boolean
    // deklarasi variabel LocalDataSource dengan entitas nama dan kelas (stok)
    // untuk proses menambahkan data buah
    fun addStudent(context: Context, nama:String, kelas:String, onSuccess:(Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.saveStudent(StudentEntity(0, nama, kelas))
        onSuccess(true)
    }

    // terdapat fungsi updateStudent dengan deklarasi nama,dan kelas (stok) menggunakan tipe data string.
    // jika sukses maka akan bertipe data boolean
    // deklarasi variabel LocalDataSource dengan entitas nama dan kelas (stok)
    // untuk proses pembaruan data buah
    fun updateStudent(context: Context, id:Int, nama:String, kelas:String, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.updateStudent(StudentEntity(id, nama, kelas))
        onSuccess(true)
    }

    // terdapat fungsi deleteStudent dengan deklarasi nama,dan kelas (stok) menggunakan tipe data string.
    // jika sukses maka akan bertipe data boolean
    // deklarasi variabel LocalDataSource dengan entitas nama dan kelas (stok)
    // untuk proses penghapusan data buah
    fun deleteStudent(context: Context, data:StudentEntity, onSuccess: (Boolean) -> Unit) {
        val localDataSource = LocalDataSource(context)
        localDataSource.deleteStudent(data)
        onSuccess(true)
    }

}