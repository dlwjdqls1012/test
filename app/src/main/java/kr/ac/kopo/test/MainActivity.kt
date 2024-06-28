package kr.ac.kopo.test

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var imgbtn: ImageButton

    private var clickCount = 0
    private var currentImageIndex = 0
    private val images = arrayOf(
        R.drawable.gu,
        R.drawable.spah,
        R.drawable.tpah,
        R.drawable.star
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "도형변경"

        imgbtn = findViewById(R.id.imgbtn)
        imgbtn.setOnClickListener {
            clickCount++
            if (clickCount < 1000) {
                val scale = 1 + clickCount / 100f
                imgbtn.scaleX = scale
                imgbtn.scaleY = scale
            } else {
                clickCount = 0
                currentImageIndex = (currentImageIndex + 1) % images.size
                imgbtn.setImageResource(images[currentImageIndex])
                imgbtn.scaleX = 1.0f
                imgbtn.scaleY = 1.0f
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itemgu -> {
                imgbtn.setImageResource(R.drawable.gu)
                item.setChecked(true)
                return true
            }
            R.id.itemspah -> {
                imgbtn.setImageResource(R.drawable.spah)
                item.setChecked(true)
                return true
            }
            R.id.itemtpah -> {
                imgbtn.setImageResource(R.drawable.tpah)
                item.setChecked(true)
                return true
            }
            R.id.itemstar -> {
                imgbtn.setImageResource(R.drawable.star)
                item.setChecked(true)
                return true
            }
        }
        return false
    }
}
