package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.subhelper

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel

abstract class ContactsDbHelperImpl : BaseDbHelper(), ContactsDbHelper {


    override fun insertRecord(itemSellDb: ConversionHistoryModel) {
        mAppDatabase?.contactsDao()?.insertRecord(itemSellDb)
    }

    override fun getAllRecords(): List<ConversionHistoryModel>? {
        return mAppDatabase?.contactsDao()?.getAllHistory()
    }

  /*  override fun getAllContactsLastThreeDays(
        fr: Timestamp,
        to: Timestamp
    ): List<ConversionHistoryModel>? {
        return mAppDatabase?.contactsDao()?.getHistoryUsingTimeSpan(fr, to)
    }*/

}