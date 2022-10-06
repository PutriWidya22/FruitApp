package com.putri.fruit.room

import androidx.room.*

// berikut merupakan query untuk menampilkan data di database tb_student dengan perintah SELECT
@Dao
interface StudentDao {
    @Query("SELECT * FROM tb_student")
    suspend fun getAllStudents() : List<StudentEntity>

    // untuk menambahkan data dengan perintah insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(data:StudentEntity)

    // untuk mengubah data atau memperbarui data dengan perintah update
    @Update
    suspend fun updateStudent(data:StudentEntity)

    // untuk menghapus data dengan perintah delete
    @Delete
    suspend fun deleteStudent(data:StudentEntity)
}