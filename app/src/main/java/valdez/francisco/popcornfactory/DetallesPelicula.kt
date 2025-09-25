package valdez.francisco.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class DetallesPelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_pelicula)
        val imgPelicula: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val txtNombrePelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        val txtDescPelicula: TextView = findViewById(R.id.tv_pelicula_desc)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val btn_buy_tickets: Button = findViewById(R.id.btn_buy_tickets)
        var id = -1
        val bundle = intent.extras
        var title = "";
        var ns = 0;


        if (bundle != null){
            ns = bundle.getInt("numberSeats")

            imgPelicula.setImageResource(bundle.getInt("header"))
            txtNombrePelicula.setText(bundle.getString("nombre"))
            txtDescPelicula.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
            title = bundle.getString("nombre")!!
            id = bundle.getInt("pos")
        }

        if (ns == 0){
            btn_buy_tickets.isEnabled = false
        }else{
            btn_buy_tickets.setOnClickListener {
                val intent =  Intent(this, SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }

        }
    }
}