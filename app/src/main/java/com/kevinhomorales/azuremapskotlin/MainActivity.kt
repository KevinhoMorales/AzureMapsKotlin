package com.kevinhomorales.azuremapskotlin

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.kevinhomorales.azuremapskotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpView()
    }

    private fun setUpView() {
        setUpMap()
    }

    fun setUpMap() {
        // Configurar ajustes del WebView
        val webSettings: WebSettings = binding.mapWebViewId.settings
        webSettings.javaScriptEnabled = true           // Activar JavaScript
        webSettings.domStorageEnabled = true           // Activar almacenamiento DOM
        webSettings.useWideViewPort = true             // Usar el ancho completo de la vista
        webSettings.loadWithOverviewMode = true        // Ajustar el contenido al tamaño de la pantalla

        // Asegurarse de que la pantalla ocupa el espacio completo
        binding.mapWebViewId.setInitialScale(1)         // Escalar el contenido adecuadamente
        binding.mapWebViewId.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        // Cargar el archivo HTML
        binding.mapWebViewId.loadUrl("file:///android_asset/map.html")
    }
}