package giam.myapplication.DataBase.users;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

import giam.myapplication.DataBase.users.UserContract.UserEntry;

/**
 * ENTIDAD "user"
 */
public class Users {

    private String id;
    private String name;
    private String password;
    private String avatarUri;

    public Users(String name,
                 String password,
                 String avatarUri) {
        this.id             = UUID.randomUUID().toString();
        this.name           = name;
        this.password       = password;
        this.avatarUri      = avatarUri;
    }

    public Users(Cursor cursor) {
        id                  = cursor.getString(cursor.getColumnIndex(UserEntry.ID));
        name                = cursor.getString(cursor.getColumnIndex(UserEntry.NAME));
        password            = cursor.getString(cursor.getColumnIndex(UserEntry.PASSWORD));
        avatarUri           = cursor.getString(cursor.getColumnIndex(UserEntry.AVATAR_URI));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UserEntry.ID, id);
        values.put(UserEntry.NAME, name);
        values.put(UserEntry.PASSWORD, password);
        values.put(UserEntry.AVATAR_URI, avatarUri);
        return values;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatarUri() {
        return avatarUri;
    }
}
