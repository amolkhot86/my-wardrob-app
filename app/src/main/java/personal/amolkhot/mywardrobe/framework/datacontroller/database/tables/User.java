package personal.amolkhot.mywardrobe.framework.datacontroller.database.tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * Created by amol.khot on 24-Oct-18.
 */

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int user_id;

    @NotNull
    @ColumnInfo(name = "title")
    public  String title;

    public User(@NotNull String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    @NotNull
    public String getTitle() {
        return this.title;
    }}