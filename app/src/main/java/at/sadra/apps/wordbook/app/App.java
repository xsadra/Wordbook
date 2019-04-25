package at.sadra.apps.wordbook.app;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class App {

    public static void toast(Context context, String message) {
        makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void log(String message) {
        Log.e(Values.TAG, message);
    }

    public static class Values {
        public static final String TAG = "WORD";
        public static final String DATABASE_NAME = "word_DataBase";
        public static final int DATABASE_VERSION = 1;
    }

    public static class Message {
        public static final String SUCCESS = "Success!";
    }

    public static class Error {
        public static final String FAILED = "Failed!";
    }

    public static class Query {
        public static final String DELETE_ALL = "DELETE FROM word_table";
        public static final String SELECT_ALL_FROM_WORD_ORDER_BY_DATEINFO = "SELECT * FROM word_table ORDER BY dateInfo DESC";
    }
}
