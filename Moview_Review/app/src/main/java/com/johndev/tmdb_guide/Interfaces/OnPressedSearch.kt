package com.johndev.tmdb_guide.Interfaces

import com.johndev.tmdb_guide.SearchData.SearchCommon.SearchData

interface OnPressedSearch {
    fun onSearchPressed(data: SearchData)
}