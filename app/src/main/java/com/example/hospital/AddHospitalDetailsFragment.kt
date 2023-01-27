package com.example.hospital

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.HospitalModel.hospitalData
import com.example.hospital.R


class AddHospitalDetailsFragment : Fragment() {
    lateinit var HospitalName:EditText
    lateinit var Speciality:EditText
    lateinit var Location:EditText
    lateinit var saveBtn:Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add_hospital_details, container, false)
        saveBtn=view.findViewById(R.id.saveBtn)
        HospitalName=view.findViewById(R.id.etOfHospitalName)
        Speciality=view.findViewById(R.id.etOfSpeciality)
        Location=view.findViewById(R.id.etOfLocation)


        var name=HospitalName.text

       //  Log.i("nam",name.toString())
        val spec=Speciality.text.toString()
        val loc=Location.text.toString()
       //  myList.add(hospitalData(name,spec,loc))

        saveBtn.setOnClickListener {

                view: View->
            //Log.i("na",name.toString())
            var bundle=Bundle()
            bundle.putString("HospitalName",name.toString())
            bundle.putString("Speciality",spec)
            bundle.putString("Location",loc)
            val mainFragment=HospitalListFragment()
            mainFragment.arguments =bundle

            view.findNavController()
                .navigate(R.id.action_addHospitalDetailsFragment_to_hospitalList2)
        }

        return view
    }


}