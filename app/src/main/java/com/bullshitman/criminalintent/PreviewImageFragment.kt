package com.bullshitman.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

private const val IMAGE_PATH = "path"

class PreviewImageFragment : DialogFragment() {
    private lateinit var imagePrev: ImageView
    private lateinit var imagePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imagePath = arguments?.getSerializable(IMAGE_PATH) as String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.image_fullsize, container, false)
        imagePrev = view.findViewById(R.id.image_preview) as ImageView
        val bitmap =  getScaledBitmap(imagePath, requireActivity())
        imagePrev.setImageBitmap(bitmap)
        return view
    }

    companion object {
        fun newInstance(path: String) : PreviewImageFragment {
            val args = Bundle().apply {
                putSerializable(IMAGE_PATH, path)
            }
            return PreviewImageFragment().apply {
                arguments = args
            }
        }
    }
}