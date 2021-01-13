package com.example.contactlist;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private ArrayList<ContactItem> contactItemArrayList;
    private ArrayList<String> colorCodes;

    public ContactAdapter(ArrayList<ContactItem> contactItemArrayList) {
        this.contactItemArrayList = contactItemArrayList;
        this.colorCodes = new ArrayList<>();
        this.colorCodes.add("#e60099");
        this.colorCodes.add("#cc6600");
        this.colorCodes.add("#00ff00");
        this.colorCodes.add("#99ff33");
        this.colorCodes.add("#0066cc");
        this.colorCodes.add("#ccccff");
        this.colorCodes.add("#00ffcc");
        this.colorCodes.add("#cc33ff");
        this.colorCodes.add("#ff5050");
        this.colorCodes.add("#66ff66");
        this.colorCodes.add("#0099ff");
        this.colorCodes.add("#99ccff");
        this.colorCodes.add("#9966ff");
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactItem contactItem = contactItemArrayList.get(position);
        holder.tvName.setText(contactItem.getName());
        holder.tvNumber.setText(contactItem.getNumber());
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactItemArrayList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, contactItemArrayList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactItemArrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvNumber;
        public Button deleteBtn;
        public CardView cardView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvNumber = itemView.findViewById(R.id.tvNumber);
            deleteBtn = itemView.findViewById(R.id.ivDelete);
            cardView = itemView.findViewById(R.id.cardView);
            cardView.setBackgroundColor(Color.parseColor(colorCodes.get((int)(Math.random()*10))));
        }
    }
}
