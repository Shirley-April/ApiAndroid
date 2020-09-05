package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProgressBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val progressBar = findViewById<ProgressBar>(R.id.progressbar_control)
            val progressText = findViewById<TextView>(R.id.progressbar_value_text)
            val increaseBar = findViewById<Button>(R.id.increase_button)
            val decreaseBar = findViewById<Button>(R.id.decrease_button)

            increaseBar.setOnClickListener {
                progressBar.progress += 10
                progressText.text = "${progressBar.progress}/${progressBar.max}"
                //modifyProgressBar(10)
            }
            decreaseBar.setOnClickListener {
                progressBar.progress += -10
                progressText.text = "${progressBar.progress}/${progressBar.max}"
                //modifyProgressBar(-10)
            }
            progressBar.max = 150
            progressBar.progress = 99
            progressText.text = "${progressBar.progress}/${progressBar.max}"
        }
    }

}
}