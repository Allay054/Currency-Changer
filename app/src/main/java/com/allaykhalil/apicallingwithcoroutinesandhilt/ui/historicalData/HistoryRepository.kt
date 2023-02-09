package com.allaykhalil.apicallingwithcoroutinesandhilt.ui.historicalData


import com.allaykhalil.apicallingwithcoroutinesandhilt.base.BaseRepository
import com.allaykhalil.apicallingwithcoroutinesandhilt.managers.DataManager
import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel
import java.sql.Timestamp
import javax.inject.Inject

class HistoryRepository @Inject constructor(dataManager: DataManager) :
    BaseRepository(dataManager) {

    suspend fun fetchRecordsFromDb(): List<ConversionHistoryModel>? {
        return dataManager.getDbHelper().getAllRecords()
    }

    /*suspend fun fetchContactsFromDbLastThreeDays(fr: Timestamp, to: Timestamp): List<ConversionHistoryModel>? {
        return dataManager.getDbHelper().getAllContactsLastThreeDays(fr,to)
    }*/
}