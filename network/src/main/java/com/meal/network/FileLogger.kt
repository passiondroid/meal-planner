import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileLogger: KoinComponent {

    private val context: Context by inject()
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    var logFile: File = File(context.filesDir, "${getLogFileName()}_logs.txt")

    init {
        // Specify the file path where you want to store logs
        if (!logFile.exists()) {
            logFile.createNewFile()
        }
    }


    fun log(message: String) {
        println("==== $message")
        try {
            // Append the log entry to the internal log file
            FileWriter(logFile, true).use { fileWriter ->
                val timestamp = dateFormat.format(Date())
                val logEntry = "$timestamp: $message\n"
                fileWriter.append(logEntry)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getFileUri(file: File): Uri {
        return FileProvider.getUriForFile(
            context,
            "com.meal.planner",
            file
        )
    }

    private fun getLogFileName(): String {
        return "meal_planner"
    }

}