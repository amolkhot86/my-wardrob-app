package personal.amolkhot.mywardrobe.framework.datacontroller.database.datahandlers;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import personal.amolkhot.mywardrobe.framework.datacontroller.database.tables.User;

/**
 * Created by amol.khot on 24-Oct-18.
 */

@Dao
public interface UserHandler {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("Select * FROM User")
    List<User> getAllUsers();
}
