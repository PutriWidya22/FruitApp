package com.putri.fruit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.putri.fruit.databinding.ActivityAddStudentBinding
import com.putri.fruit.room.StudentEntity

// membuat class AddStudentActivity dengan kelas binding yang mengekstends dari AppCompactActivity
class AddStudentActivity : AppCompatActivity() {

    // deklarasi binding dan viewModel yaitu kelas ActivityAddStudentBinding dan AddStudentViewModel
    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var viewModel:AddStudentViewModel

    // deklarasi variabel idEdit dengan nilai false
    // deklarasi variabel data entity dengan nilai null
    private var isEdit = false
    private var data:StudentEntity? = null

    // deklarasi variabel STUDENT_EXTRA dengan nilai student.
    companion object {
        val STUDENT_EXTRA = "student"
    }

    // membuat activity dengan konsep binding, yang di dalamnya terdapat intent pada variabel data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.getParcelableExtra(STUDENT_EXTRA)

        // jika data bernilai tidak null maka data bisa di edit seperti nama dan stok
        // dan data juga dapat dihapus.
        if (data != null) {
            isEdit = true
            binding.btnHapus.visibility = View.VISIBLE
            binding.editName.setText(data?.name)
            binding.editKelas.setText(data?.kelas)
        } else {
            isEdit = false
            binding.btnHapus.visibility = View.GONE
        }

        // pada action bar memberikan nilai true
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // menyertakan viewModel pada kelas AddStudentViewModel
        viewModel = ViewModelProvider(this)[AddStudentViewModel::class.java]

        // membuat button simpan untuk menyimpan data buat saat mengklik tombol simpan dan disimpan
        // di saveStudent
        binding.btnSimpan.setOnClickListener {
            saveStudent()
        }

        // membuat button hapus untuk menghapus data buah, dan jika berhasil terhapus maka akan
        // menampilkan popup "Berhasil Menghapus Data Buah
        binding.btnHapus.setOnClickListener {
            viewModel.deleteStudent(this, data!!) {
                Toast.makeText(this, "Berhasil Menghapus Data Buah", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // membuat function saveStudent untuk menyimpan data Buah yang telah dimasukkan
    // mulai dari menambahkan data dengan tipe data string
    // dan menambahkan data untuk update atau memperbarui data, dengan tipe data string.
    private fun saveStudent() {
        if (binding.editName.text.toString() == "" || binding.editKelas.text.toString() == "") {
            Toast.makeText(this, "Isi Form yang ada", Toast.LENGTH_SHORT).show()
        } else {
            if (isEdit) {
                viewModel.updateStudent(this, data?.id!!, binding.editName.text.toString(), binding.editKelas.text.toString()) {
                    successSaveStudent()
                }
            } else {
                viewModel.addStudent(this, binding.editName.text.toString(), binding.editKelas.text.toString()) {
                    successSaveStudent()
                }
            }
        }
    }

    // membuat function successSaveStudent yang nantinya jika data disimpan dan berhasil maka akan
    // menampilkan popup "Berhasil Menyimpan Data Buah".
    private fun successSaveStudent() {
        Toast.makeText(this, "Berhasil Menyimpan Data Buah", Toast.LENGTH_SHORT).show()
        finish()
    }

    // membuat function onSupportNavigateUp yang bernilai boolean dan hasil true.
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}