package com.example.curtislavaud.hope;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Curtis Lavaud on 11/03/2019.
 */

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.fragment_settings, container, false);

         Button btnEditProfile = (Button) view.findViewById(R.id.btn_EditProfile);
         btnEditProfile.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent in = new Intent(getActivity(), ProfileActivity.class);
                 startActivity(in);
                 Toast.makeText(getActivity(),"Edit profile" ,Toast.LENGTH_SHORT).show();
             }
         });
        Button btnHelp = (Button) view.findViewById(R.id.btn_Help);
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), HelpActivity.class);
                startActivity(in);
            }
        });
       Button btnAbout = (Button) view.findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AboutActivity.class);
                startActivity(in);
            }
        });

        Button btnlogout = (Button) view.findViewById(R.id.btn_logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), MainActivity.class);
                startActivity(in);
                Toast.makeText(getActivity(),"Successfully logged out" ,Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

