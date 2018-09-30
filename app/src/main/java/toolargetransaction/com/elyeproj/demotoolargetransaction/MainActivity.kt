package toolargetransaction.com.elyeproj.demotoolargetransaction

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.livefront.bridge.Bridge
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Bridge.clearAll(applicationContext)
        }

        btn_too_large_transaction.setOnClickListener {
            startActivity(Intent(this, TooLargeTransactionActivity::class.java))
        }
        btn_live_bridge_transaction.setOnClickListener {
            startActivity(Intent(this, LiveBridgeActivity::class.java))
        }
    }
}
