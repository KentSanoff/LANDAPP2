package com.kentsanoff.landapp.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LandFieldDao {
    @Insert
    suspend fun insert(field: LandField)

    @Update
    suspend fun update(field: LandField)

    @Delete
    suspend fun delete(field: LandField)

    @Query("SELECT * FROM land_fields ORDER BY editDate DESC")
    fun getAll(): Flow<List<LandField>>

    @Query("SELECT * FROM land_fields WHERE id = :id")
    suspend fun getById(id: Int): LandField?
}
