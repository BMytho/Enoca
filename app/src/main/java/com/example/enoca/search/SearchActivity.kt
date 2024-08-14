package com.example.enoca.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enoca.R
import com.example.enoca.databinding.FragmentSearchBinding
import java.util.Locale

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var recyclerView1: RecyclerView
    private lateinit var imageList: Array<Int>
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>
    private lateinit var titleList : ArrayList<String>
    private lateinit var dataList : ArrayList<DataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment için XML dosyasını şişiriyoruz
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        // Başlangıç ayarlarını burada yapıyoruz
        init(view)

        return view
    }

    private fun init(view: View) {
        imageList = arrayOf(
            R.drawable.i,
            R.drawable.dune,
            R.drawable.avatar,
            R.drawable.batman,
            R.drawable.fight,
            R.drawable.karayip,
            R.drawable.rocky
        )

        titleList = arrayListOf("Yıldızlararası", "Dune", "Avatar", "Batman", "Fight Club", "Karayip Korsanları", "Rocky")

        recyclerView1 = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.search)
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.setHasFixedSize(true)

        dataList = arrayListOf()
        searchList = arrayListOf()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataList.forEach {
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView1.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView1.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView1.adapter = SearchAdapter(searchList)
    }
}
