package com.mini.jonghams.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.mini.jonghams.R
import com.mini.jonghams.ViewPager.ShopViewPagerAdapter
import com.mini.jonghams.fragment.CalendarFragment
import com.mini.jonghams.fragment.CommentFragment
import com.mini.jonghams.fragment.ContactFragment
import com.mini.jonghams.fragment.FoodFragment
import com.mini.jonghams.utills.isOnWorkingTime
import kotlinx.android.synthetic.main.activity_shop_detail.*


class ShopDetailActivity : AppCompatActivity() {
    private val TAG = "PermissionDemo"
    private val RECORD_REQUEST_CODE = 101

    private val tabIcons = intArrayOf(
        R.drawable.ic_shop_contact,
        R.drawable.ic_shop_product,
        R.drawable.ic_shop_calendar,
        R.drawable.ic_shop_comment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)
        setSupportActionBar(toolbar)

        if (supportActionBar != null)
            toolbar.setNavigationIcon(R.drawable.ic_arrow_left)
        supportActionBar!!.title = null
        shopOpenStatus()
        setupViewPager(view_pager)

        with(tabs) {
            setupWithViewPager(view_pager)
            getTabAt(0)?.setIcon(tabIcons[0])
            getTabAt(1)?.setIcon(tabIcons[1])
            getTabAt(2)?.setIcon(tabIcons[2])
            getTabAt(3)?.setIcon(tabIcons[3])

            addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    view_pager.currentItem = tab.position
                    val tabIconColor = ContextCompat.getColor(
                        context,
                        R.color.colorPrimaryDark
                    )
                    tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    val tabIconColor =
                        ContextCompat.getColor(
                            context,
                            R.color.black
                        )
                    tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                }

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ShopViewPagerAdapter(supportFragmentManager)
        with(adapter) {
            addFrag(ContactFragment(), "Contact")
            addFrag(FoodFragment(), "Product")
            addFrag(CalendarFragment(), "Calendar")
            addFrag(CommentFragment(), "Comment")
        }
        viewPager.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_like -> {
                Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_edit -> {
                Toast.makeText(this, "Please login first", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_share -> {
                shareToFacebook()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareToFacebook() {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "https://www.tutorialspoint.com/index.htm")
        val installed = checkAppInstall("com.facebook.katana")
        if (installed) {
            intent.setPackage("com.facebook.katana")
            startActivity(intent)
        } else {
            Toast.makeText(applicationContext, "No facebook app install", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkAppInstall(uri: String): Boolean {
        val pm = packageManager
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return false
    }

    fun onPhoneCall(view: View) {
        setupPhoneCall(getString(R.string.my_phone_num))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            RECORD_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "Permission has been denied by user")
                } else {
                    Log.i(TAG, "Permission has been granted by user")
                }
            }
        }
    }

    fun setupPhoneCall(phoneNum: String) {
        val permission = ContextCompat.checkSelfPermission(
            this, Manifest.permission.CALL_PHONE
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CALL_PHONE), RECORD_REQUEST_CODE
            )
        } else {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNum"))
            startActivity(intent)
        }
    }

    fun onMapView(view: View) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://maps.google.com/maps?saddr=11.57270,104.8987&daddr=11.539768,104.910317")
        )
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun shopOpenStatus() {
        if (isOnWorkingTime(7, 21)) {
            status.text = getString(R.string.open_now)
            status.setTextColor(Color.parseColor("#1CE407"))
        } else {
            status.text = getString(R.string.closed)
            status.setTextColor(Color.parseColor("#2E2D2D"))
        }
    }
}