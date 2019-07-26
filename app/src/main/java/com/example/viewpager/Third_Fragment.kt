package com.example.viewpager

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_third_fragment.*

class Third_Fragment() : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    val view : View = inflater.inflate(R.layout.layout_third_fragment,null)
        return view
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        third_webView.loadUrl("https://www.geeksforgeeks.org")

        third_webView.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        third_webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE

        if (Build.VERSION.SDK_INT >= 19) {
            third_webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {

            third_webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        third_webView.webViewClient = object :WebViewClient()
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
                Toast.makeText(context,"Error @loading:" + error,Toast.LENGTH_SHORT).show()
            }
        }
    }
}