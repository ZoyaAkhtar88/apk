import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoUrlInput = findViewById<EditText>(R.id.videoUrl)
        val downloadBtn = findViewById<Button>(R.id.downloadBtn)

        val videoDownloader = VideoDownloader(this)

        downloadBtn.setOnClickListener {
            val url = videoUrlInput.text.toString()
            if (url.isNotEmpty()) {
                videoDownloader.downloadVideo(url, "DownloadedVideo")
            }
        }
    }
}
