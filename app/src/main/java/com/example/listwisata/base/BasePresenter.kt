package com.example.listwisata.base

import com.example.listwisata.MainActivity
import com.example.listwisata.updatedelete.UpdateDeleteConstruct

interface BasePresenter<T : BaseView> {
    fun onAttach(view: MainActivity)
    fun onDetach()
    fun onAttach(view: UpdateDeleteConstruct)
}