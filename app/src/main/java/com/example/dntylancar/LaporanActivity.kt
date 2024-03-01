package com.example.dntylancar


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dntylancar.databinding.FragmentLaporanBinding
//import com.example.dntylancar.databinding.FragmentPopUpReportBindingn
//import com.google.android.material.bottomsheet.BottomSheetDialog

class LaporanActivity : AppCompatActivity() {
    private val binding by lazy { FragmentLaporanBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.btnAddReport.setOnClickListener {
//            showBottomSheet()
//        }
    }

//    private fun showBottomSheet(){
//        val sheetDialog = BottomSheetDialog(this)
//        val sheetBinding = ActivityPopUpReportBinding.inflate(layoutInflater)
//        sheetDialog.apply {
//            setContentView(sheetBinding.root)
//            show()
//        }
//
//        sheetBinding.btnSend_report.setOnClickListener{
//            sheetDialog.dismiss()
//        }
//    }

}