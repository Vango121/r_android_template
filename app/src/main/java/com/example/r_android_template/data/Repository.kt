package com.example.r_android_template.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map

private const val PREFERENCE_NAME = "Service"
class Repository( @ApplicationContext private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)
    companion object {

        val ID = intPreferencesKey("id")

    }
    suspend fun saveId(id: Int){
        context.dataStore.edit {
            it[ID] = id
        }
    }
    suspend fun getID() = context.dataStore.data.map {
        it[ID]?:1
    }
}


