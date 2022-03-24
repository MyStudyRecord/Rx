package com.study.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.study.rx.data.User
import com.study.rx.data.UserProfile
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fromIterableOperator()
        /*       repeatOperator().subscribe({
                   Log.d(MainActivity.TAG, "onNext : $it")
               },{
                   Log.d(MainActivity.TAG, "onError : $it")
               },{
                   Log.d(MainActivity.TAG, "onComplete")
               })*/
        /*    intervalOperator().subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
                getLocation()
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/

        /*      createOperator().subscribe({
                  Log.d(MainActivity.TAG, "onNext : $it")
              },{
                  Log.d(MainActivity.TAG, "onError : $it")
              },{
                  Log.d(MainActivity.TAG, "onComplete")
              })*/
/*        filterOperator()
            .filter{
                it.name=="demo2"
            }
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/
/*        lastOperator()
            .last( User(1,"demo1",15))
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            })*/
        /*       distinctOperator()
                  *//* .distinct{
                it.age
            }*//*
            .distinct()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/
/*        skipOperator()
            //앞에서 2개 뛰고
            //.skip(2)
            //뒤에서 2개 뛰고
//            .skipLast(2)
            //distinct 나 skipLast 순서에 따라 값이 달라짐
            //distinct()
                //시간으로 스킵가능
            //.skip(1, TimeUnit.MILLISECONDS)
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        bufferOperator()
            .buffer(5)
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/

        /*      mapOperator()
                  *//*.map {
                it.age * 2
            }*//*
            .map {
                UserProfile(it.id, it.name, it.age, "https://test.com/${it.id}")
            }
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            },{
                Log.d(MainActivity.TAG, "onError : $it")
            },{
                Log.d(MainActivity.TAG, "onComplete")
            })*/

  /*      flatMapOperator()
            .flatMap {
                getUserProfile(it.id)
            }
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })

        flatMapOperatorTow()
            .flatMap {
                Observable.fromIterable(it)
            }
            .flatMap {
                getUserProfile(it.id)
            }
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        flatMapOperator()
            .flatMap {
                getUserProfile(it.id)
            }
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

   /*     groupByOperator()
            .groupBy {
                it.age
            }
    *//*        .filter {
                it.key == 10
            }*//*
   *//*         .flatMapSingle {
                it.toList()
            }*//*
            .subscribe({group ->
                group.subscribe(
                    {
                        Log.d(MainActivity.TAG, "key : ${group.key}, value : $it")

                    },
                    {

                    },
                )
              Log.d(MainActivity.TAG, "onNext : $group")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        mergeOperator()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

    /*    concatOperator()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        startWithOperator()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        zipOperator()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        getBlogs()
            .subscribe({
                Log.d(MainActivity.TAG, "onNext : $it")
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

/*        zipOperator()
            .subscribe({
                it.forEach {
                    Log.d(MainActivity.TAG, "onNext : $it")
                }
            }, {
                Log.d(MainActivity.TAG, "onError : $it")
            }, {
                Log.d(MainActivity.TAG, "onComplete")
            })*/

        createObservable().subscribe(observer())
    }

    private fun getLocation() {
        Log.d(TAG, "Latitude : 102.0303 Longitude : 1.2355")
    }
}