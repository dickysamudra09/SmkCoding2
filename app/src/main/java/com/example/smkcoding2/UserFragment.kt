package com.example.smkcoding2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment(){

    companion object{
        val REQUEST_CODE = 10000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        getData()
    }

//    private fun getData(){
//        val data = intent.extras
//
//        val nama = data.getString("Nama")
//        val no = data.getString("No.Telpon")
//        val alamat = data.getString("Alamat")
//
//        txUsername.text = nama
//        txHp.text = no
//        txAlamat.text = alamat
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == REQUEST_CODE){
//            if (resultCode == Activity.RESULT_OK) {
//                val resultName = data?.getStringExtra("Name")
//                txUsername.text = resultName
//                val resultTelp = data?.getStringExtra("No.Telpon")
//                txHp.text = resultTelp
//                val resultAlamat = data?.getStringExtra("Alamat")
//                txAlamat.text = resultAlamat
//            }
//        }else{
//            Toast.makeText(this,"Edit Failed", Toast.LENGTH_SHORT).show()
//        }
//    }
}