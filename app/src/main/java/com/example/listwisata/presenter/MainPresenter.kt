package com.example.listwisata.presenter

import com.example.listwisata.MainActivity
import com.example.listwisata.api.ApiConfig
import com.example.listwisata.base.BasePresenter
import com.example.listwisata.model.ResponseListWisata
import com.example.listwisata.updatedelete.UpdateDeleteConstruct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainActivity) : BasePresenter<MainConstruct.view>,
    MainConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        mainView =view
    }

    override fun onDetach() {
        mainView
    }

    override fun getAllWisata() {
        ApiConfig.service.getWisata().enqueue(object : Callback<ResponseListWisata> {
            override fun onResponse(
                call: Call<ResponseListWisata>,
                response: Response<ResponseListWisata>
            ) {
                if (response.isSuccessful || response.code()==200){
                    val msg = response.body()?.status
                    val sukses = response.body()?.status

                    if(sukses != null){
                        val dataWisata = response?.body()?.data
                        mainView?.showDataWisata(dataWisata)
                    } else{
                        mainView?.showMessage(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseListWisata>, t: Throwable) {
                mainView?.showError(t.message.toString())
            }

        })
    }

    override fun addWisata(
        katWisata: Int,
        nameWisata: String,
        priceWisata: String,
        descWisata: String,
        cityWisata: String,
        provinceWisata: String,
        addressWisata: String,
        openWisata: String,
        latWisata: String,
        longWisata: String,
        imgWisata: String
    ) {
        ApiConfig.service.addWisata(katWisata, nameWisata, priceWisata, descWisata, cityWisata, provinceWisata, addressWisata, openWisata, latWisata, longWisata, imgWisata).enqueue(object : Callback<ResponseListWisata>{
            override fun onResponse(
                call: Call<ResponseListWisata>,
                response: Response<ResponseListWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val status = response.body()?.status

                    if (status != null) {
                        mainView?.onSuccessInsert()
                        mainView?.showMessage(msg.toString())
                    } else {
                        mainView?.showMessage(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseListWisata>, t: Throwable) {
                mainView?.showError(t.message.toString())
            }
        })

    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        TODO("Not yet implemented")
    }
}