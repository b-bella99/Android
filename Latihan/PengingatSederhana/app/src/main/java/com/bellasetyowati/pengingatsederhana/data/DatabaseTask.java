package com.bellasetyowati.pengingatsederhana.data;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.RoomDatabase;

import java.lang.ref.WeakReference;

public class DatabaseTask extends AsyncTask<Object, Void, Void> {
    private WeakReference<Context> databaseContext;
    private DatabaseTaskEvenListener eventListener;
    private Object operationResult;

    public DatabaseTask(Context context, DatabaseTaskEvenListener eventListener){
        this.databaseContext = new WeakReference<>(context);
        this.eventListener = eventListener;
    }

    @Override
    protected Void doInBackground(Object... objects) {
        RoomDatabase database = Provider.getAsyncronousInstance(this.databaseContext.get());

        this.operationResult = this.eventListener.runDatabaseOperation(database, objects);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        this.eventListener.onDatabaseOperationfinished(this.operationResult);
    }
}
