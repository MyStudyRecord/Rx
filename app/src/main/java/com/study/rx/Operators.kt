package com.study.rx

import android.util.Log
import com.study.rx.data.User
import com.study.rx.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit

val mListNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val arraysNum1 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val arraysNum2 = arrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120)
val mUserList = mutableListOf<User>(
    User(1, "demo1", 15),
    User(2, "demo2", 10),
    User(3, "demo3", 35),
    User(4, "demo4", 29),
    User(5, "demo5", 12),
    User(6, "demo6", 29),
    User(7, "demo7", 29),
    User(7, "demo7", 29),
    User(8, "demo8", 15),
    User(8, "demo8", 15)
    )

val mUserProfileList = mutableListOf<UserProfile>(
    UserProfile(1, "demo1", 15, "aa"),
    UserProfile(2, "demo2", 10, "aa"),
    UserProfile(3, "demo3", 35, "aa"),
    UserProfile(4, "demo4", 29, "aa"),
    UserProfile(5, "demo5", 12, "aa"),
    UserProfile(6, "demo6", 29, "aa"),
    UserProfile(7, "demo7", 29, "aa"),
    UserProfile(7, "demo7", 29, "aa"),
    UserProfile(8, "demo8", 15, "aa"),
    UserProfile(8, "demo8", 15, "aa")
)


fun justOperator() {
    val observable = Observable.just(mListNum)

    val observer = object : Observer<List<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError : $e")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }

        override fun onNext(t: List<Int>) {
            Log.d(MainActivity.TAG, "onNext : $t")
        }

    }

    observable.subscribe(observer)
}

fun fromOperator() {
    val observable = Observable.fromArray(arraysNum1)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError : $e")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }

        override fun onNext(t: Array<Int>) {
            Log.d(MainActivity.TAG, "onNext : ${Arrays.toString(t)}")
        }
    }

    observable.subscribe(observer)
}

fun fromIterableOperator() {
    val observable = Observable.fromIterable(mListNum)

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            Log.d(MainActivity.TAG, "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(MainActivity.TAG, "onError : $e")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }

        override fun onNext(t: Int) {
            Log.d(MainActivity.TAG, "onNext : $t")
        }
    }

    observable.subscribe(observer)
}

fun rangeOperator(): Observable<Int> {
    return Observable.range(1, 1900)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 10).repeat(2)
}

fun intervalOperator(): Observable<Long> {
    return Observable.interval(1, TimeUnit.SECONDS).takeWhile { value ->
        value <= 10
    }
}

fun timerOperator(): Observable<Long> {
    return Observable.timer(5, TimeUnit.SECONDS)
}

fun createOperator(): Observable<Int> {
    return Observable.create(ObservableOnSubscribe<Int> {
        try {
            for (i in mListNum) {
                it.onNext(i * 5)
            }

            it.onComplete()

        } catch (e: Exception) {
            it.onError(e)
        }
    })
}

fun filterOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun lastOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun distinctOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun skipOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun bufferOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun mapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun flatMapOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}

fun getUserProfile(id : Long): Observable<UserProfile> {
    return Observable.fromIterable(mUserProfileList)
        .filter {
            it.id == id
        }
}

fun flatMapOperatorTow(): Observable<List<User>> {
    return Observable.just(mUserList)
}

fun groupByOperator(): Observable<User> {
    return Observable.fromIterable(mUserList)
}