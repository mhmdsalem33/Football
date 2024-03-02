package com.sa.football.presention.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sa.football.data.core.Resource
import com.sa.football.databinding.ActivityMainBinding
import com.sa.football.presention.extentions.hide
import com.sa.football.presention.extentions.isVisible
import com.sa.football.presention.extentions.preventScreenCapture
import com.sa.football.presention.extentions.show
import com.sa.football.presention.extentions.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch




//   tools must be installed on android studio from sdk manager  -> Sdk Tools .
//   1-> ndk sdk
//   2-> CMake
//   3-> Android sdk
//



//   1-> Mvvm  architecture
//   2-> Kotlin co-routines
//   3-> Retrofit
//   4-> Okhttp
//   5-> Okhttp logging-interceptor
//   6-> Dagger Hilt
//   7-> Room database
//   8-> Ksp




@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val binding by viewBinding(ActivityMainBinding::inflate)

    private val mainViewModel: MainViewModel by viewModels()
    private var coroutineScope: CoroutineScope? = null
    private val competitionAdapter by lazy { CompetitionAdapter() }



    companion object {
        var me: MainActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        me = this



        coroutineScope = lifecycleScope

        preventScreenCapture()
        initCompetitionRecyclerView()
        observeCompetitionsRemoteData()


    }

    private fun initCompetitionRecyclerView() {
        binding.competitionRecView.apply {
            adapter = competitionAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeCompetitionsRemoteData() {
        coroutineScope?.launch {
            mainViewModel.getCompetitionsResponse.collect { result ->
                val competitionList =  result.data
                competitionAdapter.differ.submitList(competitionList)

                binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        me = null
    }
}