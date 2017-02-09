package giam.myapplication.DataBase.users;
import android.provider.BaseColumns;

/**
 * Esquema de la tabla de datos para usuarios
 */
public class UserContract {
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME   =   "user";
        public static final String ID           =   "id";
        public static final String NAME         =   "name";
        public static final String PASSWORD     =   "password";
        public static final String AVATAR_URI   =   "avatarUri";
    }
}
