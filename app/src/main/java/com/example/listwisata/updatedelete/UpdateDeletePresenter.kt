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

    }

    override fun onAttach(view: UpdateDeleteConstruct) {
        updateDeleteView
    }

    override fun onDetach() {
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
                        updateDeleteView?.onSuccessUpdate()
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    } else {
                        updateDeleteView?.showMessageUpdate(msg.toString())
                    }

                }
            }

            override fun onFailure(call: Call<ResponseListWisata>, t: Throwable) {
                updateDeleteView?.showError(t.message.toString())
            }

        })
    }

    override fun deleteWisata(idWisata: String) {
        ApiConfig.service.deleteWisata(idWisata).enqueue(object :
        Callback<ResponseListWisata>{
            override fun onResponse(
                call: Call<ResponseListWisata>,
                response: Response<ResponseListWisata>
            ) {
                if (response.isSuccessful || response.code() == 200) {
                    val msg = response.body()?.status
                    val status = response.body()?.status
                    if (status != null){
                        updateDeleteView?.showMessageDelete(msg.toString())
                        updateDeleteView?.onSuccessDelete()
                    } else{
                        updateDeleteView?.showMessageDelete(msg.toString())
                    }
                }
            }

            override fun onFailure(call: Call<ResponseListWisata>, t: Throwable) {
                updateDeleteView?.showError(t.message.toString())
            }
        })
    }


}