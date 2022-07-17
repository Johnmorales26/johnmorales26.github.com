package com.johndev.smartcalculator.usecases.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.johndev.smartcalculator.databinding.FragmentMainUpdatesBinding
import com.johndev.smartcalculator.usecases.Adapters.HistoryUpdatesAdapter
import com.johndev.smartcalculator.usecases.base.DescriptionUpdates
import com.johndev.smartcalculator.usecases.base.HistoryUpdates

class MainUpdatesFragment : Fragment() {

    private var _binding: FragmentMainUpdatesBinding? = null
    private val binding get() = _binding!!
    private lateinit var historyUpdatesAdapter: HistoryUpdatesAdapter
    private val notData: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainUpdatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView()
    }

    private fun configureRecyclerView() {
        historyUpdatesAdapter = HistoryUpdatesAdapter(dataInflate())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = historyUpdatesAdapter
        }
    }

    private fun dataInflate(): MutableList<HistoryUpdates>{
        return mutableListOf(
            HistoryUpdates(1, "V. 2.2.0.0", descriptionsFunctions(7), descriptionsFormulas(notData), descriptionsOthers(notData)),
            HistoryUpdates(2, "V. 2.1.0.2", descriptionsFunctions(notData), descriptionsFormulas(notData), descriptionsOthers(6)),
            HistoryUpdates(3, "V. 2.1.0.1", descriptionsFunctions(notData), descriptionsFormulas(notData), descriptionsOthers(5)),
            HistoryUpdates(4, "V. 2.1.0.0", descriptionsFunctions(4), descriptionsFormulas(notData), descriptionsOthers(notData)),
            HistoryUpdates(5, "V. 2.0.0.0", descriptionsFunctions(notData), descriptionsFormulas(notData), descriptionsOthers(3)),
            HistoryUpdates(6, "V. 1.5.0.0", descriptionsFunctions(notData), descriptionsFormulas(notData), descriptionsOthers(2)),
            HistoryUpdates(7, "V. 1.0.0.0", descriptionsFunctions(1), descriptionsFormulas(1), descriptionsOthers(100)),
        )
    }

    private fun descriptionsFunctions(option: Int): MutableList<DescriptionUpdates> {
        return when(option){
            1 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Álgebra"),
                    DescriptionUpdates(2, "Porcentaje"),
                    DescriptionUpdates(3, "Promedio"),
                    DescriptionUpdates(4, "Proporción"),
                    DescriptionUpdates(5, "Ecuaciones"),
                    DescriptionUpdates(6, "Fracciones"),
                    DescriptionUpdates(7, "MCD / MCM"),
                    DescriptionUpdates(8, "Combinaciones"),
                    DescriptionUpdates(9, "Números Primos"),
                    DescriptionUpdates(10, "Generador de Números"),
                    DescriptionUpdates(11, "Geometría"),
                    DescriptionUpdates(12, "Triangulo"),
                    DescriptionUpdates(13, "Triangulo Rectángulo"),
                    DescriptionUpdates(14, "Cuadrado"),
                    DescriptionUpdates(15, "Rectángulo"),
                    DescriptionUpdates(16, "Trapezoide"),
                    DescriptionUpdates(17, "Rombo"),
                    DescriptionUpdates(18, "Pentágono"),
                    DescriptionUpdates(19, "Hexágono"),
                    DescriptionUpdates(20, "Circulo"),
                    DescriptionUpdates(21, "Arco Circular"),
                    DescriptionUpdates(22, "Ovalo"),
                    DescriptionUpdates(23, "Cuerpos"),
                    DescriptionUpdates(24, "Cubo"),
                    DescriptionUpdates(25, "Prisma"),
                    DescriptionUpdates(26, "Pirámide"),
                    DescriptionUpdates(27, "Pirámide Cortada"),
                    DescriptionUpdates(28, "Cono"),
                    DescriptionUpdates(29, "Cono Cortado"),
                    DescriptionUpdates(30, "Cilindro"),
                    DescriptionUpdates(31, "Esfera"),
                    DescriptionUpdates(32, "Tapa Esfera"),
                    DescriptionUpdates(33, "Segmento de Esfera"),
                    DescriptionUpdates(34, "Elipsoide"))
            }
            4 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Nuevo Apartado Conversor De Unidades"),
                    DescriptionUpdates(2, "Aceleración"),
                    DescriptionUpdates(3, "Almacenamiento De Datos"),
                    DescriptionUpdates(4, "Ángulo")
                )
            }
            7 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Conversor De Areas"),
                    DescriptionUpdates(2, "Conversor De Energías"),
                    DescriptionUpdates(3, "Conversor De Fuerzas")
                )
            }
            else -> {
                mutableListOf(DescriptionUpdates(1, "No hubo actualización"))
            }
        }
    }

    private fun descriptionsFormulas(option: Int): MutableList<DescriptionUpdates> {
        return when(option){
            1 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Formulas De Álgebra"),
                    DescriptionUpdates(2, "Formulas De Formas"),
                    DescriptionUpdates(3, "Formulas De Cuerpos"))
            }
            else -> { mutableListOf(DescriptionUpdates(1, "No hubo actualización")) }
        }
    }

    private fun descriptionsOthers(option: Int): MutableList<DescriptionUpdates> {
        return when(option){
            2 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Corrección De Errores De Contraste"),
                    DescriptionUpdates(2, "Correccion De Funcionamiento De Pantallas"),
                    DescriptionUpdates(3, "Adición De Detalles Del Desarrollador"),
                    DescriptionUpdates(4, "Adición De Anuncios")
                )
            }
            3 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Corrección De Error"),
                    DescriptionUpdates(2, "Cambio En Los Colores Del Tema"),
                    DescriptionUpdates(3, "Adición De Nuevas Funcionalidades"))
            }
            5 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Corrección De Errores Y Mantenimiento"))
            }
            6 -> {
                mutableListOf(
                    DescriptionUpdates(1, "Corrección De Errores"),
                    DescriptionUpdates(1, "Adición De Nuevas Vistas De Bienvenida"))
            }
            else -> { mutableListOf(DescriptionUpdates(1, "No hubo actualización")) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}