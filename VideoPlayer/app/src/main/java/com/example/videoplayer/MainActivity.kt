package com.example.videoplayer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener{

                val intent = Intent()
                intent.type = "video/*"
                intent.action = Intent.ACTION_PICK
                startActivityForResult(Intent.createChooser(intent, "Select Video"),REQUEST_CODE)
        }
    }


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            if (data?.data != null) {
                val uriPathHelper = URIPathHelper()
                val videoFullPath = uriPathHelper.getPath(this, data?.data!!) // Use this video path according to your logic
                // if you want to play video just after picking it to check is it working
                if (videoFullPath != null) {
                    playVideoInDevicePlayer(videoFullPath);
                }
            }
        }
    }


    fun playVideoInDevicePlayer(videoPath: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoPath))
        intent.setDataAndType(Uri.parse(videoPath), "video/mp4")
        startActivity(intent)
    }

}