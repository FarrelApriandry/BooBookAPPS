package com.example.dntylancar

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.smarteist.autoimageslider.SliderView
import com.example.dntylancar.databinding.ActivityPopUpReportBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    var currentLayout: View? = null

    fun removeLayout(view: View) {
        if (view.parent != null) {
            (view.parent as ViewGroup).removeView(view)
        }
    }

    // on below line we are creating a variable
    // for our array list for storing our images.
    lateinit var imageUrl: ArrayList<String>

    // on below line we are creating
    // a variable for our slider view.
    lateinit var sliderView: SliderView

    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile = findViewById<View>(R.id.btn_profile) as ImageButton
        btnProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity, GuestLoginActivity::class.java))
        }

        val stub = findViewById<ViewStub>(R.id.layout_stub)
        stub.layoutResource = R.layout.activity_halaman_utama
        val inflated = stub.inflate()
        currentLayout = inflated

        val btnHomeActive = findViewById<ImageButton>(R.id.btn_homepage)
        val btnKoleksiActive = findViewById<ImageButton>(R.id.btn_koleksi)
        val btnPeringkatActive = findViewById<ImageButton>(R.id.btn_peringkat)
        val btnLaporanActive = findViewById<ImageButton>(R.id.btn_laporan)

        sliderView = findViewById(R.id.slider)

        // on below line we are initializing
        // our image url array list.
        imageUrl = ArrayList()

        // on below line we are adding data to our image url array list.
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_1)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_2)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_3)

        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter( imageUrl)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)

        // on below line we are setting scroll time
        // in seconds for our slider view.
        sliderView.scrollTimeInSec = 3

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()


        btnHomeActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_active)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_inactive)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_inactive)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_inactive)

            removeLayout(currentLayout!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.activity_halaman_utama, null, false)

            // Add the inflated layout to the parent view
            val parentView = findViewById<ViewGroup>(R.id.parent_stub) // Replace with the actual ID of the parent view
            parentView.addView(layout)
            currentLayout = layout
        }

        btnKoleksiActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_inactive)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_active)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_inactive)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_inactive)

            removeLayout(currentLayout!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.activity_koleksi, null, false)

            // Add the inflated layout to the parent view
            val parentView = findViewById<ViewGroup>(R.id.parent_stub) // Replace with the actual ID of the parent view
            parentView.addView(layout)
            currentLayout = layout

            val btnTerbaru = findViewById<Button>(R.id.btn_terkini_koleksi)
            val btnFavorit = findViewById<Button>(R.id.btn_favorit_koleksi)
            val btnRiwayat = findViewById<Button>(R.id.btn_riwayat_koleksi)
            val textViewKoleksi = findViewById<TextView>(R.id.koleksiText)

            val underlineBtnTerbaru = findViewById<View>(R.id.underlineBtn_terbaru_koleksi)
            val underlineBtnFavorit = findViewById<View>(R.id.underlineBtn_favorit_koleksi)
            val underlineBtnRiwayat = findViewById<View>(R.id.underlineBtn_riwayat_koleksi)

            underlineBtnFavorit.isInvisible = true
            underlineBtnRiwayat.isInvisible = true

            btnTerbaru.setOnClickListener() {
                underlineBtnTerbaru.isInvisible = false
                underlineBtnFavorit.isInvisible = true
                underlineBtnRiwayat.isInvisible = true
                btnTerbaru.setTextColor(Color.parseColor("#292929"))
                btnFavorit.setTextColor(Color.parseColor("#80292929"))
                btnRiwayat.setTextColor(Color.parseColor("#80292929"))
                btnTerbaru.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.sixteen_sp))
                btnFavorit.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                btnRiwayat.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                textViewKoleksi.text = getString(R.string.koleksiTerbaru)
            }

            btnFavorit.setOnClickListener() {
                underlineBtnTerbaru.isInvisible = true
                underlineBtnFavorit.isInvisible = false
                underlineBtnRiwayat.isInvisible = true
                btnTerbaru.setTextColor(Color.parseColor("#80292929"))
                btnFavorit.setTextColor(Color.parseColor("#292929"))
                btnRiwayat.setTextColor(Color.parseColor("#80292929"))
                btnTerbaru.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                btnFavorit.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.sixteen_sp))
                btnRiwayat.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                textViewKoleksi.text = getString(R.string.koleksiFavorit)
            }

            btnRiwayat.setOnClickListener() {
                underlineBtnTerbaru.isInvisible = true
                underlineBtnFavorit.isInvisible = true
                underlineBtnRiwayat.isInvisible = false
                btnTerbaru.setTextColor(Color.parseColor("#80292929"))
                btnFavorit.setTextColor(Color.parseColor("#80292929"))
                btnRiwayat.setTextColor(Color.parseColor("#292929"))
                btnTerbaru.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                btnFavorit.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                btnRiwayat.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.sixteen_sp))
                textViewKoleksi.text = getString(R.string.koleksiRiwayat)
            }

        }

        btnPeringkatActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_inactive)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_inactive)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_active)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_inactive)

            removeLayout(currentLayout!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.activity_peringkat, null, false)

            // Add the inflated layout to the parent view
            val parentView = findViewById<ViewGroup>(R.id.parent_stub) // Replace with the actual ID of the parent view
            parentView.addView(layout)

            currentLayout = layout

            val btnPinjaman = findViewById<Button>(R.id.btn_pinjaman_peringkat)
            val btnKunjungan = findViewById<Button>(R.id.btn_kunjungan_peringkat)
            val textViewPinjaman = findViewById<TextView>(R.id.peringkatText)

            val underlineBtnPinjaman =findViewById<View>(R.id.underlineBtn_pinjaman_peringkat)
            val underlineBtnPeringkat =findViewById<View>(R.id.underlineBtn_kunjungan_peringkat)

            underlineBtnPeringkat.isInvisible = true

            btnPinjaman.setOnClickListener() {
                underlineBtnPinjaman.isInvisible = false
                underlineBtnPeringkat.isInvisible = true
                btnPinjaman.setTextColor(Color.parseColor("#292929"))
                btnKunjungan.setTextColor(Color.parseColor("#80292929"))
                btnPinjaman.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.sixteen_sp))
                btnKunjungan.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                textViewPinjaman.text = getString(R.string.peringkatPinjaman)
            }

            btnKunjungan.setOnClickListener() {
                underlineBtnPinjaman.isInvisible = true
                underlineBtnPeringkat.isInvisible = false
                btnPinjaman.setTextColor(Color.parseColor("#80292929"))
                btnKunjungan.setTextColor(Color.parseColor("#292929"))
                btnPinjaman.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.fourteen_sp))
                btnKunjungan.setTextSize(TypedValue.COMPLEX_UNIT_PX,resources.getDimension(R.dimen.sixteen_sp))
                textViewPinjaman.text = getString(R.string.peringkatKunjungan)
            }

        }

        btnLaporanActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_inactive)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_inactive)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_inactive)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_active)

            removeLayout(currentLayout!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.activity_laporan, null, false)

            // Add the inflated layout to the parent view
            val parentView = findViewById<ViewGroup>(R.id.parent_stub) // Replace with the actual ID of the parent view
            parentView.addView(layout)

            currentLayout = layout

            val btnAddReport = findViewById<ImageButton>(R.id.btn_add_report)

            btnAddReport.setOnClickListener {
                showBottomSheet()
            }

        }
    }

    private fun showBottomSheet(){

        val sheetDialog = BottomSheetDialog(this)
        val sheetBinding = ActivityPopUpReportBinding.inflate(layoutInflater)
        val layoutParams = ViewGroup.LayoutParams(200, 200)
        sheetDialog.apply {
            setContentView(sheetBinding.root)
            show()
        }

        sheetBinding.btnSendReport.setOnClickListener{
            sheetDialog.dismiss()
        }
    }
}
