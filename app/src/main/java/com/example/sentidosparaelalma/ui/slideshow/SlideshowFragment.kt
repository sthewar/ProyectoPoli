package com.example.sentidosparaelalma.ui.slideshow

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sentidosparaelalma.R
import com.example.sentidosparaelalma.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val myVideo: VideoView = binding.myVideoView

        val videoUri: Uri = Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.videopruebas)
        myVideo.apply {
            myVideo.start()
            setVideoURI(videoUri)
        }

        // Botón Play
        binding.playButton.setOnClickListener {
            if (!myVideo.isPlaying) {
                myVideo.start()
            }
        }

        // Botón Pause
        binding.pauseButton.setOnClickListener {
            if (myVideo.isPlaying) {
                myVideo.pause()
            }
        }

        // Botón Stop
        binding.stopButton.setOnClickListener {
            if (myVideo.isPlaying) {
                myVideo.stopPlayback()
                myVideo.setVideoURI(videoUri)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}