package toolargetransaction.com.elyeproj.demotoolargetransaction


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evernote.android.state.State
import com.livefront.bridge.Bridge
import kotlinx.android.synthetic.main.fragment_too_large_transaction.*

class LiveBridgeIssueFragment : Fragment() {

    companion object {
        const val KEY = "KeyIndex"
        const val TAG = "LiveBridgeIssueFragment"

        fun newInstance(index: Int): Fragment {
            val argument = Bundle()
            argument.putInt(KEY, index)
            val fragment = LiveBridgeIssueFragment()
            fragment.arguments = argument
            return fragment
        }
    }

    @State
    var data: IntArray? = null

    private var size: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        size = (arguments?.getInt(KEY) ?: 0) * 100000

        Bridge.restoreInstanceState(this, savedInstanceState)
        if (savedInstanceState == null) {
            data = IntArray(size)
        }

        return inflater.inflate(R.layout.fragment_too_large_transaction, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Bridge.saveInstanceState(this, outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt_index.text = "${data?.size} elements"
    }
}
