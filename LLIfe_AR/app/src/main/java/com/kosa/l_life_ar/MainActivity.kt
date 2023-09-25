package com.kosa.l_life_ar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.lifecycle.lifecycleScope
import com.google.ar.core.Config
import com.kosa.l_life_ar.databinding.ActivityMainBinding
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener{
            val nextIntent = Intent(this, ArActivity::class.java)
            startActivity(nextIntent)
        }
    }
}