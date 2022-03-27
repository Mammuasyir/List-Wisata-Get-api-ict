package com.example.listwisata

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listwisata.model.DataItem
import com.example.listwisata.presenter.MainPresenter
import com.example.listwisata.presenter.WisataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainPresenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)
        mainPresenter?.getAllWisata()
    }

    fun showDataWisata(dataWisata: List<DataItem?>?){
        val adapterWisata = WisataAdapter(dataWisata, this)
        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = adapterWisata
        }
    }
    fun showMessage(msg : String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }

    fun onSuccessInsert() {
        mainPresenter?.getAllWisata()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add -> {
                insertDialog()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDialog() {
        val alert = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_insert, null)
        alert.setView(view)
        alert.setCancelable(false)
        alert.setTitle("Add New Wisata")
        alert.setPositiveButton(
            "Save",
            DialogInterface.OnClickListener { dialogInterface, i ->
                val katWisata = view.findViewById<EditText>(R.id.edt_kategori)
                val nameWisata = view.findViewById<EditText>(R.id.edt_nama_wisata)
                val priceWisata = view.findViewById<EditText>(R.id.edt_harga)
                val descWisata = view.findViewById<EditText>(R.id.edt_deskripsi_wisata)
                val cityWisata = view.findViewById<EditText>(R.id.edt_kota_wisata)
                val provinceWisata = view.findViewById<EditText>(R.id.edt_provinsi_wisata)
                val addressWisata = view.findViewById<EditText>(R.id.edt_alamat_wisata)
                val openWisata = view.findViewById<EditText>(R.id.edt_waktubuka_wisata)
                val latWisata = view.findViewById<EditText>(R.id.edt_latitude_wisata)
                val longWisata = view.findViewById<EditText>(R.id.edt_longitude_wisata)
                val imgWisata = view.findViewById<EditText>(R.id.edt_url_gambar)

                mainPresenter?.addWisata(
                    katWisata.text.length,
                    nameWisata.text.toString(),
                    priceWisata.text.toString(),
                    descWisata.text.toString(),
                    cityWisata.text.toString(),
                    provinceWisata.text.toString(),
                    addressWisata.text.toString(),
                    openWisata.text.toString(),
                    latWisata.text.toString(),
                    longWisata.text.toString(),
                    imgWisata.text.toString()
                )
                dialogInterface.dismiss()
            })
        alert.setNeutralButton("close", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() })
        alert.show()
    }
}