package com.allaykhalil.apicallingwithcoroutinesandhilt.data.local.db.subhelper

import com.allaykhalil.apicallingwithcoroutinesandhilt.models.dbModels.ConversionHistoryModel

interface ContactsDbHelper {
    /*fun insertContacts(contacts: List<ContactsModel>)*/

    fun insertRecord(itemSellDb: ConversionHistoryModel)

    //  fun deleteAllContacts()

    fun getAllRecords(): List<ConversionHistoryModel>?

    //fun getAllContactsLastThreeDays(fr: Timestamp, to: Timestamp): List<ConversionHistoryModel>?


}