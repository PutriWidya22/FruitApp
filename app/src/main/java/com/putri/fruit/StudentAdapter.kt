package com.putri.fruit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.putri.fruit.databinding.StudentItemBinding
import com.putri.fruit.room.StudentEntity

// membuat class StudentAdapter yang digunakan sebagai penghubung dengan activity yang lain
class StudentAdapter(private val listener:OnItemAction) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    // membuat inner class ViewHolder dengan menyertakan entitas nama dan kelas (stok)
    inner class ViewHolder(private val binding:StudentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:StudentEntity) {
            binding.studentName.text = item.name
            binding.studentKelas.text = item.kelas

            binding.rowStudent.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    // deklarasi variabel studentList untuk menyisipkan list data buah dengan menggunakan array
    private val studentList = ArrayList<StudentEntity>()

    // membuat fungsi setData dengan menyeryakan list data buag
    fun setData(items:List<StudentEntity>) {
        studentList.clear()
        studentList.addAll(items)
        notifyDataSetChanged()
    }

    // membuat fungsi onCreateViewHolder, onBindViewHolder, getItemCount untuk mengatur tata letak
    // atau posisi dari list data buah.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount(): Int = studentList.size

    // mengatur interdace entitas data buah
    interface OnItemAction {
        fun onItemClick(data:StudentEntity)
    }
}