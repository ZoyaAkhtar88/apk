import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment

class VideoDownloader(private val context: Context) {

    fun downloadVideo(videoUrl: String, fileName: String) {
        val request = DownloadManager.Request(Uri.parse(videoUrl))
            .setTitle("Downloading Video")
            .setDescription("Downloading $fileName")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_MOVIES, "$fileName.mp4")

        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)
    }
}

fun scanFile(context: Context, filePath: String) {
    val file = File(filePath)
    MediaScannerConnection.scanFile(context, arrayOf(file.absolutePath), null) { _, _ -> }
}

