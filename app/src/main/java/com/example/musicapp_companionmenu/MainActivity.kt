// No seu arquivo MainActivity.kt
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buyButton1: Button = findViewById(R.id.buyButton1)
        val buyButton2: Button = findViewById(R.id.buyButton2)
        val buyButton3: Button = findViewById(R.id.buyButton3)

        buyButton1.setOnClickListener {
            openWhatsApp("Olá, estou interessado na guitarra. Qual o preço final?")
        }

        buyButton2.setOnClickListener {
            openWhatsApp("Olá, estou interessado no contrabaixo. Qual o preço final?")
        }

        buyButton3.setOnClickListener {
            openWhatsApp("Olá, estou interessado na bateria. Qual o preço final?")
        }
    }

    private fun openWhatsApp(message: String) {
        try {
            val url = "https://api.whatsapp.com/send?phone=+5513981430940&text=" + Uri.encode(message)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
