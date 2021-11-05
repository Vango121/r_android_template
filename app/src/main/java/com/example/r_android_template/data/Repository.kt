package com.example.r_android_template.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map

private const val PREFERENCE_NAME = "Service"
class Repository( @ApplicationContext private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
    companion object {

        val ID = intPreferencesKey("id")

    }
    //save id in datastore
    suspend fun saveId(id: Int){
        context.dataStore.edit {
            it[ID] = id
        }
    }

    //get id from datastore and return flow<Int>
    fun getID() = context.dataStore.data.map {
        it[ID]?:1
    }
}


