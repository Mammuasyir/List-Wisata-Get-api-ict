package com.example.listwisata.presenter

import com.example.listwisata.base.BaseView
import com.example.listwisata.model.DataItem

interface MainConstruct {

    interface view : BaseView{
        fun showDataFood(dataWisata : List<DataItem?>?)
        fun showError(msg: String)
        fun showMessage(msg: String)
        fun onSuccessInsert()
    }

    interface Presenter{
        fun getAllWisata()
        fun addWisata(katWisata: Int, nameWisata: String, priceWisata: String, descWisata: String, cityWisata: String, provinceWisata: String, addressWisata: String, openWisata: String, latWisata: String, longWisata: String, imgWisata: String)
    }
}