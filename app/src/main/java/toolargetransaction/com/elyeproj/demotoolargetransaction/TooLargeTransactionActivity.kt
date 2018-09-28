package toolargetransaction.com.elyeproj.demotoolargetransaction

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_too_large_transaction.*

class TooLargeTransactionActivity : AppCompatActivity() {

    companion object {
        const val KEY = "KeyIndex"
    }

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_too_large_transaction)

        savedInstanceState?.let{
            index = it.getInt(KEY)
        }
        btn_add_fragment.setOnClickListener {
            index++
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, TooLargeTransactionFragment.newInstance(index))
                    .addToBackStack(TooLargeTransactionFragment.TAG)
                    .commit()
        }
    }

    override fun onBackPressed() {
        index--
        super.onBackPressed()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(KEY, index)
    }
}
