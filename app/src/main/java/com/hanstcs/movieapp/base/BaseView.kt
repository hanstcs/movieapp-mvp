package com.hanstcs.movieapp.base;

interface BaseView<T> {
    fun setPresenter(presenter: T)
}
