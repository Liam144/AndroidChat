package edu.udistrital.android.androidchat.contactlist.adapters;

import android.support.v7.widget.RecyclerView;

import edu.udistrital.android.androidchat.entities.User;

/**
 * Created by ASUS on 18/06/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user);
    void onItemLongClick(User user);
}
