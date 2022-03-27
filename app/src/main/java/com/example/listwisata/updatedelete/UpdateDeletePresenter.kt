package com.example.listwisata.updatedelete

import com.example.listwisata.MainActivity
import com.example.listwisata.api.ApiConfig
import com.example.listwisata.base.BasePresenter
import com.example.listwisata.model.ResponseListWisata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateDeletePresenter (var updateDeleteView : UpdateDeleteActivity) : BasePresenter<UpdateDeleteConstruct.view>, UpdateDeleteConstruct.Presenter {
    override fun onAttach(view: MainActivity) {
        TODO("Not yet implemented")
    }

    override fun onDetach() {
        updateDeleteView
    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        updateDeleteView
    }

    override fun editWisata(idWisata: String,
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
                            imgWisata: String) {
        ApiConfig.service.editWisata(idWisata,katWisata, nameWisata, priceWisata, descWisata, cityWisata, provinceWisata, addressWisata, openWisata, latWisata, longWisata, imgWisata).enqueue(object :
            Callback<ResponseListWisata> {
            override fun onResponse(
                call: Call<ResponseListWisata>,
                response: Response<ResponseListWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.message
                    val sukses = response.body()?.status

                    if (sukses != null) {
                        val dataWisata = response.body()?.data
                        updateDeleteView?.showMessageUpdate(msg.toString())
                        updateDeleteView?.onSuccessUpdate()
                    } else {
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseListWisata>, t: Throwable) {
                updateDeleteView?.showError(t.localizedMessage.toString())
            }

        })
    }

}