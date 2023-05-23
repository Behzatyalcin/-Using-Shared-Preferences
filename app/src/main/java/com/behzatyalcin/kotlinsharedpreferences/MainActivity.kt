package com.behzatyalcin.kotlinsharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.behzatyalcin.kotlinsharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private lateinit var record:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        record=this.getSharedPreferences("com.behzatyalcin.kotlinsharedpreferences",Context.MODE_PRIVATE)
        var name=record.getString("user","mistake")
        var age=record.getInt("age",-1)
          if(name=="mistake" || age== -1 ){

              binding.textView1.text="No Name: "
              binding.textView2.text="No Age: "
          }
         else {
              binding.textView1.text=" Name: "+ name
              binding.textView2.text=" Age: "+ age
          }


    }
       fun save(view: View){
           var myName=binding.nameText.text.toString()
           var myAge=binding.ageText.text.toString().toIntOrNull()
           if (myName!=null && myAge !=null){
               binding.textView1.text="Name: "+myName
               record.edit().putString("user",myName).apply()

               record.edit().putInt("age",myAge).apply()
               binding.textView2.text="Name: "+myAge
           }
           else{
               binding.textView1.text="Name: "
               binding.textView2.text="Age: "
           }
       }

      fun delete(view: View){
          var name=record.getString("user","mistake")
          var age=record.getInt("age",-1)
             if(name !="mistake" && age !=-1 ){
                  record.edit().remove("user").apply()
                  binding.textView1.text="Name: "
                  record.edit().remove("age").apply()
                  binding.textView2.text="Age: "

             }

      }


}