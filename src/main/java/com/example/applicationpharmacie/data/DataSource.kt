package com.example.applicationpharmacie.data

import com.example.applicationpharmacie.R

object DataSource {
    val medicationTypes = listOf(
        R.string.medtype_name_insectes,
        R.string.medtype_name_vitamines,
        R.string.medtype_name_pommades,
        R.string.medtype_name_homeopathie,
        R.string.medtype_name_urgences,
        R.string.medtype_name_medicaments
    )

    fun loadMedications(): List<Medication>{
        return listOf<Medication>(
            Medication(1, "Doliprane","Anti-douleur", "Médicaments", "21/12/2024"),
            Medication(2, "Advil","Mal de gorge", "Médicaments", "10/04/2024"),
            Medication(3, "Pansements","Pansement", "Urgences", "01/01/2026"),
            Medication(4, "Baume Saint-Bernard","Douleurs musculaires", "Pommades", "21/12/2024"),
            Medication(5, "Pschit moustiques","Anti-moustiques", "Insectes", "15/09/2025"),
            Medication(6, "Arnica","Anti-douleur", "Homéopathie", "21/12/2024"),
            Medication(7, "Berocca","Vitamine D", "Vitamines", "21/12/2028"),
        )
    }
}