package com.app.practiceapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.app.practiceapp.databinding.FragmentGameOverBinding
import com.app.practiceapp.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    private lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_game_won, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getShareIntent(): Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_my_thought, args.name ))
            .setType("text/plain")
            .intent
    }
    private fun startIntentActivity(){
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu, menu)

        if(null == getShareIntent().resolveActivity(requireActivity().packageManager)){
            menu.findItem(R.id.share_Menu)?.isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share_Menu -> startIntentActivity()
        }
        return super.onOptionsItemSelected(item)
    }
}