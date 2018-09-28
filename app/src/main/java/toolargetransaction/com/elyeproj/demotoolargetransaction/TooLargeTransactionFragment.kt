package toolargetransaction.com.elyeproj.demotoolargetransaction


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_too_large_transaction.*

class TooLargeTransactionFragment : Fragment() {


    companion object {
        const val KEY = "KeyIndex"
        const val DATA = "KeyData"
        const val TAG = "TooLargeTransactionFragment"

        fun newInstance(index: Int): Fragment {
            val argument = Bundle()
            argument.putInt(KEY, index)
            val fragment =  TooLargeTransactionFragment()
            fragment.arguments = argument
            return fragment
        }
    }

    private var data: IntArray? = null
    private var size: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        size = (arguments?.getInt(KEY)?: 0) * 100000
        data = if (savedInstanceState != null) {
            savedInstanceState.getSerializable(DATA) as IntArray
        } else {
            IntArray(size)
        }

        return inflater.inflate(R.layout.fragment_too_large_transaction, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(DATA, data)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_index.text = "$size elements"
    }
}
