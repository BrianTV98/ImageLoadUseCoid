package com.example.imageloadusingcoil

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val CAMERA_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.INTERNET),
                CAMERA_REQUEST
            )
        } else {
            imv1.load(R.drawable.background)
            imv2.load(R.drawable.background){
                transformations(RoundedCornersTransformation(25f))
            }
            imv3.load(R.drawable.background){
                transformations(CircleCropTransformation())
            }
            imv4.load(R.drawable.background){
                transformations(GrayscaleTransformation())
            }
            imv5.load(R.drawable.background){
                transformations(BlurTransformation(applicationContext,10f))
            }
            imv6.load("https://firebasestorage.googleapis.com/v0/b/messenger-bc93f.appspot.com/o/image%2Fe57e61b0-c16f-41e7-b479-e9186e29fd1d?alt=media&token=62fac349-7b61-4514-a6e3-ba550d32f21e")
        }

    }
}
