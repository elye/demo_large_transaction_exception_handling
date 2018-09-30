package toolargetransaction.com.elyeproj.demotoolargetransaction


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_too_large_transaction.*

class NothingFragment : Fragment() {

    companion object {
        const val TAG = "NothingFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_nothing_transaction, container, false)
    }

}
