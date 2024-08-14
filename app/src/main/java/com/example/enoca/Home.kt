package com.example.enoca

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enoca.databinding.FragmentHomeBinding
import com.example.enoca.filmler.Film
import com.example.enoca.filmler.FilmAdapter


class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var filmListesi: ArrayList<Film>
    private lateinit var filmAdapter: FilmAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment için XML dosyasını şişiriyoruz
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Başlangıç ayarlarını burada yapıyoruz
        init(view)

        return view
    }

    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewTopRated)
        recyclerView.setHasFixedSize(true)
        recyclerView2 = view.findViewById(R.id.recyclerViewPopular)
        recyclerView2.setHasFixedSize(true)
        recyclerView3 = view.findViewById(R.id.recyclerViewSoon)
        recyclerView3.setHasFixedSize(true)
        recyclerView4 = view.findViewById(R.id.recyclerViewNow)
        recyclerView4.setHasFixedSize(true)

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerView3.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerView4.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        filmListesi = ArrayList()
        filmDatasıEkle()

        filmAdapter = FilmAdapter(filmListesi)
        recyclerView.adapter = filmAdapter
        recyclerView2.adapter = filmAdapter
        recyclerView3.adapter = filmAdapter
        recyclerView4.adapter = filmAdapter
    }

    private fun filmDatasıEkle() {
        filmListesi.add(Film(R.drawable.i))
        filmListesi.add(Film(R.drawable.avatar))
        filmListesi.add(Film(R.drawable.dune))
        filmListesi.add(Film(R.drawable.batman))
        filmListesi.add(Film(R.drawable.rocky))
        filmListesi.add(Film(R.drawable.fight))
        filmListesi.add(Film(R.drawable.karayip))
    }
}
