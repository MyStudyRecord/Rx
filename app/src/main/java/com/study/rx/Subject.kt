package com.study.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
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

fun behaviorSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }

    val subject = BehaviorSubject.create<Long>()
    observable.subscribe(subject)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onError1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete1 ")
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

fun behaviorSubjectTwo(){
    val subject = BehaviorSubject.create<Int>()
    subject.onNext(0)
    subject.onNext(1)

    //가장 마지막인줄 알고 1을 찍고 봤더니 뒤에 2가 하나 더있어서 1,2 둘다 찍힌다 이런건가?
    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onError1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete1 ")
        }
    )
    subject.onNext(2)


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

fun publishSubject(){
    val observable = Observable.interval(1, TimeUnit.SECONDS).takeWhile { it <= 5 }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    val subject = PublishSubject.create<Long>()
    observable.subscribe(subject)
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

fun publishSubjectTwo(){
    val subject = PublishSubject.create<Int>()
    subject.onNext(0)
    subject.onNext(1)

    subject.subscribe(
        {
            Log.d(MainActivity.TAG, "onNext1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onError1 : $it")
        }, {
            Log.d(MainActivity.TAG, "onComplete1 ")
        }
    )
    subject.onNext(2)

}