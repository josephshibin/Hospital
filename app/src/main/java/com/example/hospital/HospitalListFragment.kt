package com.example.hospital

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.HospitalAdapter.HospitalAdapter
import com.example.hospital.HospitalModel.hospitalData


class HospitalListFragment : Fragment() {
    lateinit var addBtn:Button
    lateinit var recyclerView: RecyclerView
    var myList: ArrayList<hospitalData> = ArrayList<hospitalData>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


         val view= inflater.inflate(R.layout.fragment_hospital_list, container, false )
//        val binding: ViewDataBinding? = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_hospital_list, container, false)
        addBtn=view.findViewById(R.id.addHospitalBtn)
        addBtn.setOnClickListener {
                view: View->
            view.findNavController()
                .navigate(R.id.action_hospitalList_to_addHospitalDetailsFragment2)
        }
        recyclerView=view.findViewById(R.id.RecyclerView)
       //  recyclerView.layoutManager= LinearLayoutManager(this@HospitalListFragment)


        recyclerView.adapter=HospitalAdapter(this,myList) //connecting recycler view to adapter

   val HospitalName= arguments?.getString("HospitalName")
        if (HospitalName != null) {
            Log.i("msg",HospitalName)
        }
        val Speciality=arguments?.getString("Speciality").toString()
        val Location=arguments?.getString("Location").toString()
       // myList.add(hospitalData(HospitalName,Speciality,Location))

        return view

    }

//    fun addHospital(){
//
//    }


}