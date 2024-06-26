package com.example.gutierrezenzop2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper; 

public class AdminSQLiteOpenHelper  extends SQLiteOpenHelper{

	public AdminSQLiteOpenHelper(Context context, String nombre, CursorFactory factory, int version) {
		super(context, nombre, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table alquieres(dni integer primary key, nombre text, telefono integer, dias integer)");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
		db.execSQL("drop table if exists alquieres");
		db.execSQL("create table alquieres(dni integer primary key, nombre text, telefono integer, dias integer)");
	} 
}
