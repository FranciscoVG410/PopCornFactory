package valdez.francisco.popcornfactory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculaAdapter(
    private val context: Context,
    private val peliculas: ArrayList<Pelicula>,
    private val onClick: (Pelicula, Int) -> Unit
) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    class PeliculaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.iv_pelicula)
        val nombre: TextView = itemView.findViewById(R.id.tv_nombre_pelicula)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pelicula, parent, false)
        return PeliculaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.imagen.setImageResource(pelicula.image)
        holder.nombre.text = pelicula.titulo

        holder.imagen.setOnClickListener {
            onClick(pelicula, position)
        }
    }

    override fun getItemCount(): Int = peliculas.size
}
