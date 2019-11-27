package com.aniket.nearbyapp.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.aniket.nearbyapp.R;
import com.aniket.nearbyapp.utils.ObjectSerializer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    public Context context;
    int itemCount;
    public Intent intent;
    ArrayList<Store> nearbyStoreList;
    ImageView photo;

    public CustomAdapter(Context context, Intent intent,ArrayList<Store> nearbyStoreList) {
        this.context = context;
        this.intent = intent;
        this.nearbyStoreList=nearbyStoreList;
    }

    @Override
    public int getCount() {
        return nearbyStoreList.size();
    }

    @Override
    public Object getItem(int position) {
        return nearbyStoreList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View v= View.inflate(context, R.layout.customer_list_item,null);

        final TextView name=v.findViewById(R.id.name_tv);
        final TextView title=v.findViewById(R.id.title_tv);
        final TextView finalprice = v.findViewById(R.id.final_tv);
        photo=v.findViewById(R.id.store_image_tv);

        photo.setImageResource(R.drawable.logo);

        //setting up text to textviews

        final int pos=position;
        name.setText(nearbyStoreList.get(pos).name);
        title.setText(nearbyStoreList.get(pos).cards.get(0).title);
        finalprice.setText(nearbyStoreList.get(pos).cards.get(0).finalPrice);
        Log.i("STORAGE", "IN getview");
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    intent.putExtra("store", ObjectSerializer.serialize(nearbyStoreList.get(position)));
                    context.startActivity(intent);
                }
                catch (Exception e){
                    Log.i("LOG", "onClick: "+e);
                }
            }
        });
        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Log.i("STORAGE", "IN STORAGE ");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference=storage.getReference().child("images/flower.jpg");
//                Bitmap bitmap=((BitmapDrawable) photo.getDrawable()).getBitmap();
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                byte[] data = baos.toByteArray();
//
//                UploadTask uploadTask = storageReference.putBytes(data);
//                uploadTask.addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle unsuccessful uploads
//                    }
//                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                        // ...
//                    }
//                });
                storageReference.getBytes(1024*1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        photo.setImageBitmap(BitmapFactory.decodeByteArray(bytes,0,bytes.length));
                    }
                });
            }
        });*/
        return v;
    }
}
