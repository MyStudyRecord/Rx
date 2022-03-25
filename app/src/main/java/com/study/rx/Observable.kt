package com.study.rx

import android.util.Log
import com.study.rx.MainActivity.Companion.TAG
import com.study.rx.data.User
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable


fun createObservable() : Observable<Int> {
    return Observable.create{ emitter ->
        try {
            if (!emitter.isDisposed){
                for (i in 0..100){
                    emitter.onNext(i)
                }
                emitter.onComplete()
            }
        }catch (e : Exception){
            emitter.onError(e)
        }
    }
}

fun observer() : Observer<Int>{
    return object : Observer<Int>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onNext(t: Int) {
            Log.d(TAG,"onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }

    }
}

fun createSingleObservable() : Single<Int>{
    return Single.create{ emitter ->
        try {
            if (!emitter.isDisposed){
                for (i in 0..100){
                    emitter.onSuccess(i)
                }
            }
        }catch (e : Exception){
            emitter.onError(e)
        }
    }
}

fun observerSingleObservable() : SingleObserver<Int>{
    return object : SingleObserver<Int>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError")
        }

        override fun onSuccess(t: Int) {
            Log.d(TAG,"onSuccess : $t")
        }

    }
}

fun createMaybeObservable() : Maybe<List<User>>{
    return Maybe.just(mUserList)
}

fun observerMaybeObservable() : MaybeObserver<List<User>> {
    return object : MaybeObserver<List<User>>{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe : $d")
        }

        override fun onSuccess(t: List<User>) {
            t.forEach {  Log.d(TAG,"onSuccess : $it") }

        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : $e")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }

    }
}

fun createCompletableObservable() : Completable{
    return Completable.create{ emitter ->
        try {
            if (!emitter.isDisposed){
                getLocation()
                emitter.onComplete()
            }
        }catch (e : Exception){
            emitter.onError(e)
        }
    }
}

fun observeCompletableObservable(): CompletableObserver{
    return object  : CompletableObserver{
        override fun onSubscribe(d: Disposable) {
            Log.d(TAG,"onSubscribe : $d")
        }

        override fun onComplete() {
            Log.d(TAG,"onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG,"onError : $e")
        }

    }
}

fun createFlowableObservable() : Flowable<Int>{
    return Flowable.range(1,10000)
}


private fun getLocation() {
    //throw Exception("에러 ")
    Log.d(TAG, "Latitude : 102.0303 Longitude : 1.2355")
}