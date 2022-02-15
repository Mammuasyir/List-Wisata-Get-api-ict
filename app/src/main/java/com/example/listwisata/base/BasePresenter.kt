package com.example.listwisata.base

import com.example.listwisata.MainActivity

interface BasePresenter<T> {
    fun onAttach(view: MainActivity)
}