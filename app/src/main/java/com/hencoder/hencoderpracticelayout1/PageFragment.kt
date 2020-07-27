package com.hencoder.hencoderpracticelayout1

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub

class PageFragment : Fragment() {
    @LayoutRes
    var sampleLayoutRes = 0
    @LayoutRes
    var practiceLayoutRes = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val sampleStub = view.findViewById<ViewStub>(R.id.sampleStub)
        sampleStub.layoutResource = sampleLayoutRes
        sampleStub.inflate()
        val practiceStub = view.findViewById<ViewStub>(R.id.practiceStub)
        practiceStub.layoutResource = practiceLayoutRes
        practiceStub.inflate()
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args != null) {
            sampleLayoutRes = args.getInt("sampleLayoutRes")
            practiceLayoutRes = args.getInt("practiceLayoutRes")
        }
    }

    companion object {
        fun newInstance(@LayoutRes sampleLayoutRes: Int, @LayoutRes practiceLayoutRes: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt("sampleLayoutRes", sampleLayoutRes)
            args.putInt("practiceLayoutRes", practiceLayoutRes)
            fragment.arguments = args
            return fragment
        }
    }
}