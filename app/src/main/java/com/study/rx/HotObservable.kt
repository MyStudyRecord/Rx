package com.study.rx

import com.study.rx.data.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.ConnectableObservable
import java.util.*
import java.util.concurrent.TimeUnit

fun hotObservable() : ConnectableObservable<User>{
    return Observable.fromIterable(mUserList).publish()
}

fun hotObservableTwo() : ConnectableObservable<Long>{
    return Observable.interval(1, TimeUnit.SECONDS).publish()
}