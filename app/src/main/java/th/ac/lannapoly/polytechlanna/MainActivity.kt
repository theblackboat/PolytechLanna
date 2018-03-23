package th.ac.lannapoly.polytechlanna

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,
        Home.OnFragmentInteractionListener ,
        ContactFragment.OnFragmentInteractionListener{

     var homeFragment:Home? = null
     var contactFragment:ContactFragment? = null

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (homeFragment == null){
                    homeFragment = Home()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, homeFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_giftcard -> {
                if (contactFragment == null){
                    contactFragment = ContactFragment()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, contactFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeFragment = Home()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, homeFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
