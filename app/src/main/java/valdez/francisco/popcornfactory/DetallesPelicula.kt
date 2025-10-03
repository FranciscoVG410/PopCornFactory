package valdez.francisco.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallesPelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_pelicula)

        val ivPelicula: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tvNombre: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tvDesc: TextView = findViewById(R.id.tv_pelicula_desc)
        val btnComprar: Button = findViewById(R.id.btn_buy_tickets)
        val tvSeats: TextView = findViewById(R.id.seatsLeft)

        val nombre = intent.getStringExtra("nombre")
        val imagen = intent.getIntExtra("image", 0)
        val sinopsis = intent.getStringExtra("sinopsis")
        val seats = intent.getIntExtra("numberSeats", 0)

        tvNombre.text = nombre
        ivPelicula.setImageResource(imagen)
        tvDesc.text = sinopsis
        tvSeats.text = "Asientos disponibles: $seats"

        btnComprar.setOnClickListener {
            val intent = Intent(this, SeatSelection::class.java)
            intent.putExtra("name", nombre)
            intent.putExtra("seatsLeft", seats)
            startActivity(intent)
        }
    }
}
