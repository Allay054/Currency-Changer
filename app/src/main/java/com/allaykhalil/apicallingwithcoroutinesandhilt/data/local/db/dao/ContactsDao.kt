package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import java.sql.Timestamp

@Dao
abstract class ContactsDao : BaseDao<ConversionHistoryModel> {
    @Insert
    abstract fun insertRecord(itemSellDb: ConversionHistoryModel)

    @Query("Select *from SearchHistoryData")
    abstract fun getAllHistory(): List<ConversionHistoryModel>

    @Query("Delete from SearchHistoryData")
    abstract fun deleteAllHistory()

   /* @Query("Select *from SearchHistoryData WHERE strDate BETWEEN :from AND :to")
    abstract fun getHistoryUsingTimeSpan(from: Timestamp, to: Timestamp): List<ConversionHistoryModel>*/
}