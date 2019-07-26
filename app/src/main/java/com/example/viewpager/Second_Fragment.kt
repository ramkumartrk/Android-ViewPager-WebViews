package com.example.viewpager

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_second_fragment.*

class Second_Fragment() : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view : View  = inflater.inflate(R.layout.layout_second_fragment,null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       second_webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        second_webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE

        if (Build.VERSION.SDK_INT >= 19) {
            second_webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
           second_webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        second_webView.loadUrl("https://www.google.com/")
        second_webView.webViewClient = object : WebViewClient()
        {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

                view!!.loadUrl(request?.url.toString())
                return true
                 }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                Toast.makeText(context,"Error @Loading::" + error,Toast.LENGTH_SHORT).show()
            }
        }
    }
}