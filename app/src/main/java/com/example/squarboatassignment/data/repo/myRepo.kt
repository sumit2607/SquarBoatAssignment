package com.example.squarboatassignment.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.squarboatassignment.Api.Network
import com.example.squarboatassignment.Api.test.CandidateService
import com.example.squarboatassignment.Api.test.apiService
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.AvailableJobData
import com.example.squarboatassignment.data.models.Candidate.AvailableJobs.availableJobs
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class myRepo {

var list = arrayListOf<AvailableJobData>()


     fun getMovie() : List<AvailableJobData>{

         CandidateService.getApiServicetest().getavailableJobs().subscribeOn(Schedulers.io()).observeOn(
             AndroidSchedulers.mainThread()).subscribe()

         return list



    }
    fun getList() : io.reactivex.Observer<availableJobs>{
        return object : io.reactivex.Observer<availableJobs>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: availableJobs) {
              list.addAll(t.data)
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }

        }

    }
}