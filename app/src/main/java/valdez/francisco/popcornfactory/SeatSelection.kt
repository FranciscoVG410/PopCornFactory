package valdez.francisco.popcornfactory

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvTitle: TextView = findViewById(R.id.title)
        val btnConfirm: Button = findViewById(R.id.btn_Confirm)

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        val bundle = intent.extras
        if (bundle != null) {
            tvTitle.text = bundle.getString("name")
        }

        val rows = listOf(row1, row2, row3, row4)
        rows.forEach { row ->
            row.setOnCheckedChangeListener { _, checkedId ->
                if (checkedId > -1) {
                    rows.filter { it != row }.forEach { it.clearCheck() }
                }
            }
        }

        btnConfirm.setOnClickListener {
            if (selectedSeat(rows)) {
                Toast.makeText(this, "¡Disfruta tu película! :D", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Selecciona un asiento primero", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun selectedSeat(rows: List<RadioGroup>): Boolean {
        return rows.any { it.checkedRadioButtonId != -1 }
    }
}
