package com.example.footprint

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputTravel = view.findViewById<EditText>(R.id.input_travel)
        val inputElectricity = view.findViewById<EditText>(R.id.input_electricity)
        val inputWaste = view.findViewById<EditText>(R.id.input_waste)
        val btnCalculate = view.findViewById<Button>(R.id.btn_calculate)
        val tvResult = view.findViewById<TextView>(R.id.tv_result)

        btnCalculate.setOnClickListener {
            val travel = inputTravel.text.toString().toDoubleOrNull()
            val electricity = inputElectricity.text.toString().toDoubleOrNull()
            val waste = inputWaste.text.toString().toDoubleOrNull()

            if (travel != null && electricity != null && waste != null) {
                val result = calculateFootprint(travel, electricity, waste)
                tvResult.text = getString(R.string.result_format, result)
                tvResult.visibility = View.VISIBLE
            } else {
                Toast.makeText(requireContext(), "Please fill all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateFootprint(travel: Double, electricity: Double, waste: Double): Double {
        return travel * 0.3 + electricity * 0.5 + waste * 0.2
    }
}
