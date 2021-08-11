package com.mplr.rappimovie.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mplr.rappimovie.models.PopularMovie
import com.mplr.rappimovie.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var movieRepository: MovieRepository
) : ViewModel() {

    val popularMovies: MutableLiveData<PopularMovie> by lazy {
        MutableLiveData<PopularMovie>()
    }

    private val compositeDisposable = CompositeDisposable()

    fun getPopularMovies(page: Int = 0) {

        compositeDisposable += movieRepository.getPopularMovies(
            page = page
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ popularMovies ->
                setPopularMovies(popularMovies)
            }, {
                setPopularMovies(PopularMovie())
            })
    }

    private fun setPopularMovies(data: PopularMovie) {
        popularMovies.postValue(data)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}