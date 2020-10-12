package id.ac.ui.cs.mobileprogramming.prissy.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_sender.*

class MessageSenderFragment : Fragment() {
    lateinit var model: SharedViewModel
    private var message : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        button.setOnClickListener {
            message = enter_message.text.toString()
            if (!message.equals("")) {
                model.sendMessage(message)
                val fragment = MessageReceiverFragment()
                val parentManager = this.parentFragmentManager.beginTransaction()
                parentManager.replace(R.id.fragment_holder, fragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
            }
        }

    }
}
