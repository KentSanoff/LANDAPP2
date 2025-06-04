package com.kentsanoff.landapp.data.repository

import com.kentsanoff.landapp.data.db.LandField
import com.kentsanoff.landapp.data.db.LandFieldDao
import kotlinx.coroutines.flow.Flow

class LandRepository(private val dao: LandFieldDao) {

    fun getAllFields(): Flow<List<LandField>> = dao.getAll()

    suspend fun insertField(field: LandField) = dao.insert(field)

    suspend fun updateField(field: LandField) = dao.update(field)

    suspend fun deleteField(field: LandField) = dao.delete(field)

    suspend fun getFieldById(id: Int): LandField? = dao.getById(id)
}
