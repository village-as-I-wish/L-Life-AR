package com.kosa.l_life_ar

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.kosa.l_life_ar.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator


private const val NUM_PAGES = 5

class MainActivity : AppCompatActivity() {

    private var mViewPager: ViewPager? = null
    var adapter = SectionPageAdapter(supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewPager = binding.container as ViewPager
        setupViewPager(mViewPager)
        val indicator = binding.indicator as CircleIndicator
        indicator.setViewPager(mViewPager)

        binding.arBtn.setOnClickListener {
            val intent = Intent(this, ArActivity::class.java)
            startActivity(intent)
        }

    }

    fun setupViewPager(viewPager: ViewPager?) {
        adapter.addFragment(MainActivitiyFragment1(), "1")
        adapter.addFragment(MainActivityFragment2(), "2")
        adapter.addFragment(MainActivityFragment3(), "3")
        viewPager!!.adapter = adapter
    }



}