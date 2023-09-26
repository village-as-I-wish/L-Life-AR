package com.kosa.l_life_ar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.ar.core.Config
import com.kosa.l_life_ar.databinding.ActivityArBinding
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position


class ArActivity : AppCompatActivity() {

    private lateinit var sceneView: ArSceneView
    private lateinit var modelNode: ArModelNode
    private lateinit var normalView: View

    private final var FRAGMENT1 = 1
    private final var FRAGMENT2 = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityArBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sceneView = binding.sceneView.apply {
            this.lightEstimationMode = Config.LightEstimationMode.DISABLED
        }

        normalView = binding.normalView

        binding.place.setOnClickListener {
            placeModel()
        }

        binding.capture.setOnClickListener {
            binding.sceneView.planeRenderer.destroy()
        }



        modelNode = ArModelNode(binding.sceneView.engine).apply {
            placementMode = PlacementMode.BEST_AVAILABLE
            screenPosition = Position(0.0f, 0.0f, -30.0f)

            lifecycleScope.launchWhenCreated {
                loadModelGlbAsync(
                    scaleToUnits = 0.5f,
                    glbFileLocation = "models/workshop_table.glb",
                ){
                    binding.sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    binding.place.isGone
                }
            }
        }
        sceneView.addChild(modelNode)

    }


    private fun placeModel(){
        modelNode.anchor()

        sceneView.planeRenderer.isVisible = false

    }

}




//        modelNode = ArModelNode(sceneView.engine, PlacementMode.BEST_AVAILABLE).apply {
//            loadModelGlbAsync(
//                glbFileLocation = "models/workshop_table.glb",
//                scaleToUnits = 0.5f,
//                centerOrigin = Position(-0.5f)
//
//            )
//            {
//                sceneView.planeRenderer.isVisible = true
//                val materialInstance = it.materialInstances[0]
//            }
//            onAnchorChanged = {
//                binding.place.isGone = it != null
//            }
//
//        }