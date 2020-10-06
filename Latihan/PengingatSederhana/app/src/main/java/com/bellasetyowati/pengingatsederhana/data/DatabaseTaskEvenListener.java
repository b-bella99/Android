package com.bellasetyowati.pengingatsederhana.data;

import androidx.room.RoomDatabase;

public interface DatabaseTaskEvenListener {
    Object runDatabaseOperation(RoomDatabase database, Object... params);
    void onDatabaseOperationfinished(Object... result);
}
