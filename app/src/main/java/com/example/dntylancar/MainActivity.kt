package com.example.dntylancar

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import com.smarteist.autoimageslider.SliderView
import com.example.dntylancar.databinding.FragmentPopUpReportBinding
import com.example.dntylancar.databinding.FragmentBukuLampiranBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    var currentLayout: View? = null
    var stub_buku: View? =  null
    var isLogin: Boolean = false

    fun removeLayout(view: View) {
        if (view.parent != null) {
            (view.parent as ViewGroup).removeView(view)
        }
    }

    lateinit var imageUrl: ArrayList<String>
    lateinit var sliderView: SliderView
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProfile = findViewById<View>(R.id.btn_profile) as ImageButton
        btnProfile.setOnClickListener {
            startActivity(Intent(this@MainActivity, GuestLoginActivity::class.java))
        }

        val stub = findViewById<ViewStub>(R.id.layout_stub)
        stub.layoutResource = R.layout.fragment_halaman_utama
        val inflated = stub.inflate()
        currentLayout = inflated

        val btnHomeActive = findViewById<ImageButton>(R.id.btn_homepage)
        val btnKoleksiActive = findViewById<ImageButton>(R.id.btn_koleksi)
        val btnPeringkatActive = findViewById<ImageButton>(R.id.btn_peringkat)
        val btnLaporanActive = findViewById<ImageButton>(R.id.btn_laporan)

        sliderView = findViewById(R.id.slider)

        imageUrl = ArrayList()

        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_2)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_3)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_4)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_5)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_6)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_8)
        imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_7)


        sliderAdapter = SliderAdapter( imageUrl)
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 15
        sliderView.isAutoCycle = true
        sliderView.startAutoCycle()

        val stub_guest_kb = findViewById<ViewStub>(R.id.stub_guest_konten_buku)
        stub_guest_kb.layoutResource = R.layout.fragment_konten_buku_terkini
        val inflate = stub_guest_kb.inflate()
        stub_buku = inflate

        val btn_buku = findViewById<FrameLayout>(R.id.buku_1)

        btn_buku.setOnClickListener() {
            showBook()
        }

        if (isLogin == true) {
            println("logged in")
        } else {
            println("not logged in")
        }

        btnHomeActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_active)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_inactive)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_inactive)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_inactive)

            removeLayout(currentLayout!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.fragment_halaman_utama, null, false)

            // Add the inflated layout to the parent view
            val parentView = findViewById<ViewGroup>(R.id.parent_stub) // Replace with the actual ID of the parent view
            parentView.addView(layout)
            currentLayout = layout

            sliderView = findViewById(R.id.slider)

            imageUrl = ArrayList()

            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_8)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_2)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_3)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_4)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_5)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_6)
            imageUrl.add("android.resource://" + packageName + "/" + R.drawable.img_banner_7)

            sliderAdapter = SliderAdapter( imageUrl)
            sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
            sliderView.setSliderAdapter(sliderAdapter)
            sliderView.scrollTimeInSec = 10
            sliderView.isAutoCycle = true
            sliderView.startAutoCycle()

            val stub_guest_kb = findViewById<ViewStub>(R.id.stub_guest_konten_buku)
            stub_guest_kb.layoutResource = R.layout.fragment_konten_buku_terkini
            val inflate = stub_guest_kb.inflate()
            stub_buku = inflate

            val btn_buku = findViewById<FrameLayout>(R.id.buku_1)
            btn_buku.setOnClickListener() {
                showBook()
            }
        }

        btnKoleksiActive.setOnClickListener(){
            btnHomeActive.setImageResource(R.drawable.ic_homepage_inactive)
            btnKoleksiActive.setImageResource(R.drawable.ic_library_active)
            btnPeringkatActive.setImageResource(R.drawable.ic_peringkat_inactive)
            btnLaporanActive.setImageResource(R.drawable.ic_laporan_inactive)

            removeLayout(currentLayout!!)
            removeLayout(stub_buku!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.fragment_koleksi, null, false)

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
            removeLayout(stub_buku!!)

            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.fragment_peringkat, null, false)

            val parentView = findViewById<ViewGroup>(R.id.parent_stub)
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
            removeLayout(stub_buku!!)

            // Inflate the new layout
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.fragment_laporan, null, false)

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

    fun showBook() {
        val lampiranBuku = BottomSheetDialog(this, R.style.CustomBottomSheetDialogTheme)
        val bindingBuku = FragmentBukuLampiranBinding.inflate(layoutInflater)
        lampiranBuku.apply {

            var inflatedView: View? = null

            setContentView(bindingBuku.root)
            val constraintLayout1 = bindingBuku.mainConstraint
            val h = constraintLayout1.maxHeight
            val bottomSheetBehavior = BottomSheetBehavior.from(bindingBuku.root.parent as View)
            bottomSheetBehavior.peekHeight = h
            show()

            val btn_detailBuku = findViewById<Button>(R.id.btn_detail_buku)
            val btn_sinopsisBuku = findViewById<Button>(R.id.btn_sinopsis_buku)
            val underline_detailBuku = findViewById<View>(R.id.underlineBtn_buku_detail)


            val stub_detail_buku = findViewById<ViewStub>(R.id.stub_detail_buku)
            stub_detail_buku?.layoutResource = R.layout.fragment_detail_buku
            val inflate_f_detailBuku = stub_detail_buku?.inflate()
            inflatedView = inflate_f_detailBuku

            btn_detailBuku?.setOnClickListener() {
                btn_detailBuku?.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sixteen_sp))
                btn_sinopsisBuku?.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.fourteen_sp))
                btn_detailBuku?.setTextColor(Color.parseColor("#292929"))
                btn_sinopsisBuku?.setTextColor(Color.parseColor("#80292929"))
                val translationX = resources.getDimensionPixelSize(R.dimen.zero_dp).toFloat() // 75dp in pixels
                val animator = ObjectAnimator.ofFloat(underline_detailBuku, "translationX", translationX)
                animator.duration = 200 // 2 seconds
                animator.start()

                removeLayout(inflatedView!!)

                val inflated_f_detailBuku = layoutInflater
                val stub_detailBuku = inflated_f_detailBuku.inflate(R.layout.fragment_detail_buku, null, false)

                val parent_stubDetailBuku = findViewById<ViewGroup>(R.id.parent_stub_detail_buku) // Replace with the actual ID of the parent view
                parent_stubDetailBuku?.addView(stub_detailBuku)
                inflatedView = stub_detailBuku

            }

            btn_sinopsisBuku?.setOnClickListener() {
                btn_detailBuku?.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.fourteen_sp))
                btn_sinopsisBuku?.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.sixteen_sp))
                btn_detailBuku?.setTextColor(Color.parseColor("#80292929"))
                btn_sinopsisBuku?.setTextColor(Color.parseColor("#292929"))
                val translationX = resources.getDimensionPixelSize(R.dimen.translation_distance).toFloat() // 75dp in pixels
                val animator = ObjectAnimator.ofFloat(underline_detailBuku, "translationX", translationX)
                animator.duration = 200
                animator.start()

                removeLayout(inflatedView!!)

                val inflated_f_detailBuku = layoutInflater
                val stub_detailBuku = inflated_f_detailBuku.inflate(R.layout.fragment_sinopsis_buku, null, false)

                val parent_stubDetailBuku = findViewById<ViewGroup>(R.id.parent_stub_detail_buku) // Replace with the actual ID of the parent view
                parent_stubDetailBuku?.addView(stub_detailBuku)
                inflatedView = stub_detailBuku
            }
        }
    }

    private fun showBottomSheet(){

        val sheetDialog = BottomSheetDialog(this)
        val sheetBinding = FragmentPopUpReportBinding.inflate(layoutInflater)
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
