package edu.udistrital.android.androidchat.addcontact.ui;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.udistrital.android.androidchat.R;
import edu.udistrital.android.androidchat.addcontact.AddContactPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends DialogFragment implements AddContactView {


    @Bind(R.id.editTxtEmailAdd)
    EditText editTxtEmailAdd;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private AddContactPresenter presenter;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_contact, null);
        ButterKnife.bind(this, view);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        AlertDialog dialog = builder.create();
        return dialog;
    }



    @Override
    public void showInput() {
        editTxtEmailAdd.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideInput() {
        editTxtEmailAdd.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void contactAdded() {
        Toast.makeText(getActivity(),R.string.addContact_message_contactadded,Toast.LENGTH_SHORT).show();
       // presenter.addContact(editTxtEmailAdd.getText().toString());
    }

    @Override
    public void contactNoAdded() {
       editTxtEmailAdd.setText("");
       editTxtEmailAdd.setError(getString(R.string.addContact_error_message));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
