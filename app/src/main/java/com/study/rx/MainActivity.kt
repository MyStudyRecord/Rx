package com.study.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    val mList = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.just(mList)

        val observer = object : Observer<List<Int>> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError : $e")
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

            override fun onNext(t: List<Int>) {
                Log.d(TAG, "onNext : $t")
            }

        }

        observable.subscribe(observer)

    }
}