package com.example.listwisata.presenter

import com.example.listwisata.MainActivity
import com.example.listwisata.api.ApiConfig
import com.example.listwisata.base.BasePresenter
import com.example.listwisata.model.ResponseListWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var mainView: MainActivity) : BasePresenter<MainConstruct.view>,
    MainConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        mainView =view
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
}