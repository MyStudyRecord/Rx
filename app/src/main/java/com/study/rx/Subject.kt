package com.study.rx

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import java.util.concurrent.TimeUnit

fun asyncSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile{it <= 5}

    val subject = AsyncSubject.create<Long>()

    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext : $it")
        }, {
            Log.d(MainActivity.TAG, "onError : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete ")
        }
    )

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext2 : $it")
        }, {
            Log.d(MainActivity.TAG, "onError2 : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete2 ")
        }
    )
}

fun asyncSubjectTwo(){
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext : $it")
        }, {
            Log.d(MainActivity.TAG, "onError : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete ")
        }
    )
    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext2 : $it")
        }, {
            Log.d(MainActivity.TAG, "onError2 : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete2 ")
        }
    )
    subject.onNext(2)
    subject.onNext(3)
    subject.onComplete()
}

