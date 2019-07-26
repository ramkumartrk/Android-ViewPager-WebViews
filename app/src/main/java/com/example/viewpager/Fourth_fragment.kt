package com.example.viewpager

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_fourth_fragment.*

class Fourth_fragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val view : View =  inflater.inflate(R.layout.layout_fourth_fragment,null)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // super.onViewCreated(view, savedInstanceState)

        youtubeButton.setOnClickListener(View.OnClickListener {
        val url:String = "https://www.youtube.com"
        val builder : CustomTabsIntent.Builder  = CustomTabsIntent.Builder();
        val customTabsIntent  : CustomTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));

        })

    }
}