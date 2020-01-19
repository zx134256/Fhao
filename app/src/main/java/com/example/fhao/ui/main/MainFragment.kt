package com.example.fhao.ui.main

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.database.DatabaseUtils
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.ValueCallback
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fhao.R
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels


import androidx.lifecycle.*
import com.example.fhao.AppDataBase
import com.example.fhao.UserReponsitory
import com.example.fhao.data.Student
import com.example.fhao.databinding.MainFragmentBinding
import com.example.fhao.model.User
import com.example.fhao.utils.InJectorUtils


class MainFragment : Fragment() {

    var tv : TextView ? = null

    private var binding : MainFragmentBinding? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    //private val viewModel : MainViewModel by viewModels { MainViewModelFactory(UserReponsitory()) }
    private val viewModel : StudentModel by viewModels<StudentModel> { InJectorUtils.provideStudentModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.students?.observe(viewLifecycleOwner, Observer {
            val user = User()
            user.name = it[0].studentName
            user.sex = it[0].studentSex
            binding?.mainmodel = user
        })
        // TODO: Use the ViewModel



    }

    fun roomBaseInsert(){
        val studentDao = AppDataBase.getAppDataBase().getStudentDao()
        val sList :MutableList<Student> = mutableListOf()
        for (i in 1..10){
            Log.d("zx","i=$i")
            val sex : String = if (i % 2 == 0){
                "man"
            } else{
                "women"
            }
            val result : Long? = studentDao.insert(Student(i,"test%$i",sex))
            Log.d("zx","zx insert result=$result" )
        }

        Log.d("zx","zx insert insert success")
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled", "ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = User()
        user.name = "test binding"
        user.sex = "man"
        binding?.mainmodel = user
        roomBaseInsert()

        binding?.message?.setOnClickListener {

            Log.d("zx",binding?.message?.text.toString())
            Log.d("zx",viewModel.students.toString())
            val studentDao = AppDataBase.getAppDataBase().getStudentDao()
            val result : Long? = studentDao.insert(Student(0,"testchangeAgain","testSexAgain"))
        }



    }

    class ForJs{

        @JavascriptInterface
        fun getInfo() :String{
            return "hello world"
        }
    }


    val test: (Int, Int) -> Int = { a, b -> a + b }


    val test1 = { a: Int, b: Int -> a + b }

}
