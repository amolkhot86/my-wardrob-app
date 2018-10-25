package personal.amolkhot.mywardrobe.framework.datacontroller.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import personal.amolkhot.mywardrobe.framework.datacontroller.database.tables.User;
import personal.amolkhot.mywardrobe.framework.datacontroller.database.datahandlers.UserHandler;

/**
 * Created by amol.khot on 24-Oct-18.
 */

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class WardrobDb extends RoomDatabase{
    public abstract UserHandler getUserHandlerRef();
}
