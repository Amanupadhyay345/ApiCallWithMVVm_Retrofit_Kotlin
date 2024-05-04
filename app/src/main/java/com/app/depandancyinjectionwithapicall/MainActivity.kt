package com.app.depandancyinjectionwithapicall
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.peerpicks.core.extensions.showToast
import com.app.depandancyinjectionwithapicall.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
   private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel= ViewModelProvider(this)[MainViewModel::class.java]

        binding.getResponse.setOnClickListener {
          viewModel.getSkills()
        }


        viewModel.getSkillsResponse.observe(this){
            when(it){
                is NetworkResult.Loading->{
                   showToast("Loading")
                }

                is NetworkResult.Success->{
                    var data = it.data as List<Root2>

                    binding.recyclearview.visibility = View.VISIBLE
                    binding.getResponse.visibility= View.GONE
                   binding.recyclearview.apply {
                       adapter = RecyclearViewAdapter(data)
                       layoutManager = LinearLayoutManager(this@MainActivity)
                   }


                     Log.e("ResponseData", data.toString())

                }

                is NetworkResult.Error->{

                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                    Log.e("errorMessage", it.message.toString())

                    showToast("Error")

                }

                else -> {

                }
            }
        }

    }
}