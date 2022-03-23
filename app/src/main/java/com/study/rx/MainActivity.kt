package com.study.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.study.rx.data.User
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
    }

    private fun getLocation(){
        Log.d(TAG, "Latitude : 102.0303 Longitude : 1.2355")
    }
}