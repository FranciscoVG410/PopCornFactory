package valdez.francisco.popcornfactory

import android.os.Bundle
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
        val bundle = intent.extras

        if (bundle != null){
            imgPelicula.setImageResource(bundle.getInt("header"))
            txtNombrePelicula.setText(bundle.getString("nombre"))
            txtDescPelicula.setText(bundle.getString("sinopsis"))
        }
    }
}