package com.tads.peatime.ui.notifications

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.PermissionRequest
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.tads.peatime.R
import kotlinx.android.synthetic.main.fragment_camera.view.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var wbv:WebView;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_camera, container, false)

        root.wb.settings.javaScriptEnabled = true
        root.wb.settings.pluginState = WebSettings.PluginState.ON
        root.wb.settings.mediaPlaybackRequiresUserGesture = false
        root.wb.webChromeClient = object: WebChromeClient(){
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onPermissionRequest(request: PermissionRequest?) {
                activity!!.runOnUiThread {
                    request!!.grant(request.getResources())
                }
            }
        }
        wbv = root.wb
        root.wb.loadUrl("https://pet-eat-time.herokuapp.com/")
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        wbv.destroy()
    }
}