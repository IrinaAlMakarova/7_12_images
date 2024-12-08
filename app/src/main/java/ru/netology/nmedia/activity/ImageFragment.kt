package ru.netology.nmedia.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.netology.nmedia.BuildConfig
import ru.netology.nmedia.databinding.FragmentImageBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.view.load

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentImageBinding.inflate(
            inflater,
            container,
            false
        )

        fun bind(post: Post) {
            binding.apply {
                attachmentAll.visibility = View.GONE
                attachmentAll.load("${BuildConfig.BASE_URL}/media/${post.attachment?.url}")
                attachmentAll.visibility = View.VISIBLE
            }
        }

        return binding.root
    }
}