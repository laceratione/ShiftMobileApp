package com.example.shiftmobile

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftmobile.domain.model.HistoryEntity
import com.example.shiftmobile.presentation.historypage.HistoryAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

//переход по страницам главного экрана
@BindingAdapter("onNavigationItemSelected")
fun setOnNavigationItemSelectedListener(
    view: BottomNavigationView,
    listener: BottomNavigationView.OnNavigationItemSelectedListener
) {
    view.setOnNavigationItemSelectedListener(listener)
}

@BindingAdapter("setAdapter")
fun bindItemViewModels(recView: RecyclerView, items: List<HistoryEntity>?) {
    val adapter = createAdapter(recView)
    adapter.update(items)
}

private fun createAdapter(recyView: RecyclerView): HistoryAdapter {
    return if (recyView.adapter != null) {
        recyView.adapter as HistoryAdapter
    } else {
        val bindableRecyclerAdapter = HistoryAdapter()
        recyView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}
