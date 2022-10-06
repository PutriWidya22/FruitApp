package com.putri.fruit.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

// nama tabel "tb_student"
// fieldsnya id dengan tipe data int
// name dengan tipe data string
// kelas (stok) dengan tipe data string.
@Entity(tableName="tb_student")
@Parcelize
data class StudentEntity(
    @PrimaryKey(autoGenerate=true)
    val id:Int = 0,
    val name:String,
    val kelas:String
) : Parcelable