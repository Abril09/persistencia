package com.curso.persistencia


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.curso.persistencia.databinding.FragmentFirstBinding


private const val SHARED_PREFERENCE = "com.curso.persistencia";
private  const val KEY ="key"
class FirstFragment : Fragment() {
    private lateinit var mbinding:FragmentFirstBinding

    lateinit var mSharedPreferences: SharedPreferences;
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mbinding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = mbinding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        mSharedPreferences = activity?.getSharedPreferences(SHARED_PREFERENCE, Context.MODE_PRIVATE)!!
        getSave()

        mbinding.button.setOnClickListener {
             save()
            getSave()
        }

    }

    fun save(){
        mSharedPreferences.edit().putString(mbinding.editFirst.id.toString()
            ,mbinding.editFirst.text.toString())
            .putString(mbinding.editTextTextPersonName2.id.toString()
            ,mbinding.editTextTextPersonName2.text.toString())
            .putString(mbinding.editTextTextPersonName3.id.toString()
                ,mbinding.editTextTextPersonName3.text.toString())
            .apply()

    }

    fun getSave(){
        mbinding.textView2.text = mSharedPreferences.getString(mbinding.editFirst.id.toString(),"")
        mbinding.textView4.text = mSharedPreferences.getString(mbinding.editTextTextPersonName2.id.toString(),"")
        mbinding.textView7.text = mSharedPreferences.getString(mbinding.editTextTextPersonName3.id.toString(),"")
    }



}