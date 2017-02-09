package giam.myapplication.DataBase.users;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static giam.myapplication.DataBase.users.UserContract.UserEntry;

/**
 * Manejador de la Base de Datos
 */
public class UserDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Growing.db";

    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "      + UserEntry.TABLE_NAME + " ("
                + UserEntry._ID         + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UserEntry.ID          + " TEXT NOT NULL,"
                + UserEntry.NAME        + " TEXT NOT NULL,"
                + UserEntry.PASSWORD    + " TEXT NOT NULL,"
                + UserEntry.AVATAR_URI  + " TEXT,"
                + "UNIQUE (" + UserEntry.ID + "))");

        // Insertar datos ficticios para prueba inicial
        //mockData(db);
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockUser(sqLiteDatabase, new Users( "Carlos Perez",
                                                "Abogado penalista",
                                                "carlos_perez.jpg"));
        mockUser(sqLiteDatabase, new Users("Daniel Samper",
                                                "Abogado accidentes de tráfico",
                                                "daniel_samper.jpg"));
        mockUser(sqLiteDatabase, new Users("Lucia Aristizabal",
                                                "Abogado de derechos laborales",
                                                "lucia_aristizabal.jpg"));
        mockUser(sqLiteDatabase, new Users("Marina Acosta",
                                                "Abogado de familia",
                                                "marina_acosta.jpg"));
        mockUser(sqLiteDatabase, new Users("Olga Ortiz",
                                                "Abogado de administración pública",
                                                "olga_ortiz.jpg"));
        mockUser(sqLiteDatabase, new Users("Pamela Briger",
                                                "Abogado fiscalista",
                                                "pamela_briger.jpg"));
        mockUser(sqLiteDatabase, new Users("Rodrigo Benavidez",
                                                "Abogado Mercantilista",
                                                "rodrigo_benavidez.jpg"));
        mockUser(sqLiteDatabase, new Users("Tom Bonz",
                                                "Abogado penalista",
                                                "tom_bonz.jpg"));
    }

    public long mockUser(SQLiteDatabase db, Users UserTable) {
        return db.insert(
                UserEntry.TABLE_NAME,
                null,
                UserTable.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
    }

    public long saveUser(Users UserTable) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                UserEntry.TABLE_NAME,
                null,
                UserTable.toContentValues());

    }

    public Cursor getAllUsers() {
        return getReadableDatabase()
                .query(
                        UserEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getUsersById(String userId) {
        Cursor c = getReadableDatabase().query(
                UserEntry.TABLE_NAME,
                null,
                UserEntry.ID + " LIKE ?",
                new String[]{userId},
                null,
                null,
                null);
        return c;
    }

    public int deleteUser(String UserId) {
        return getWritableDatabase().delete(
                UserEntry.TABLE_NAME,
                UserEntry.ID + " LIKE ?",
                new String[]{UserId});
    }

    public int updateUser(Users user, String userID) {
        return getWritableDatabase().update(
                UserEntry.TABLE_NAME,
                user.toContentValues(),
                UserEntry.ID + " LIKE ?",
                new String[]{userID}
        );
    }
}
