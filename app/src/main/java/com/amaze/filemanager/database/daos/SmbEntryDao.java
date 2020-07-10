/*
 * Copyright (C) 2014-2020 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>,
 * Emmanuel Messulam<emmanuelbendavid@gmail.com>, Raymond Lai <airwave209gt at gmail.com> and Contributors.
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.database.daos;

import static com.amaze.filemanager.database.UtilitiesDatabase.COLUMN_NAME;
import static com.amaze.filemanager.database.UtilitiesDatabase.COLUMN_PATH;
import static com.amaze.filemanager.database.UtilitiesDatabase.TABLE_SMB;

import com.amaze.filemanager.database.models.utilities.SmbEntry;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * {@link Dao} interface definition for {@link SmbEntry}. Concrete class is generated by Room during
 * build.
 *
 * @see Dao
 * @see SmbEntry
 * @see com.amaze.filemanager.database.UtilitiesDatabase
 */
@Dao
public interface SmbEntryDao {

  @Insert
  public void insert(SmbEntry instance);

  @Update
  public void update(SmbEntry instance);

  @Query("SELECT * FROM " + TABLE_SMB)
  public SmbEntry[] list();

  @Query(
      "SELECT * FROM "
          + TABLE_SMB
          + " WHERE "
          + COLUMN_NAME
          + " = :name AND "
          + COLUMN_PATH
          + " = :path")
  public SmbEntry findByNameAndPath(String name, String path);

  @Query("DELETE FROM " + TABLE_SMB + " WHERE " + COLUMN_NAME + " = :name")
  public void deleteByName(String name);

  @Query(
      "DELETE FROM "
          + TABLE_SMB
          + " WHERE "
          + COLUMN_NAME
          + " = :name AND "
          + COLUMN_PATH
          + " = :path")
  public void deleteByNameAndPath(String name, String path);
}
