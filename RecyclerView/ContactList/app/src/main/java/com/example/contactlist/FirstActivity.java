package com.example.contactlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private ArrayList<ContactItem> contactItemArrayList;
    private RecyclerView recyclerView;
    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        recyclerView = findViewById(R.id.recyclerView);
        contactItemArrayList = new ArrayList<>();
        contactItemArrayList.add(new ContactItem("Anshu", "56789"));
        contactItemArrayList.add(new ContactItem("Madhuri", "23456"));
        contactItemArrayList.add(new ContactItem("Monu", "7843456"));
        contactItemArrayList.add(new ContactItem("Manish", "4567543"));
        contactItemArrayList.add(new ContactItem("Arpit", "345654"));
        contactItemArrayList.add(new ContactItem("Saurabh", "3456"));

        requestPermission();
        getContacts();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        ContactAdapter contactAdapter = new ContactAdapter(contactItemArrayList);
        recyclerView.setAdapter(contactAdapter);
    }

    private void getContacts() {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.d("TAG", "getContacts: " + name + " - " + number);
            contactItemArrayList.add(new ContactItem(name, number));
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d("TAG", "onRequestPermissionsResult: true");
                getContacts();
            }
            else{
                requestPermission();
            }

        }
    }
}