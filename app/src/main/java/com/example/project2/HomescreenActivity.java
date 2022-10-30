package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project2.databinding.ActivityHomescreenBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.ak1.OnBubbleClickListener;

public class HomescreenActivity extends AppCompatActivity {
ActivityHomescreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction home=getSupportFragmentManager().beginTransaction();
        home.replace(R.id.content,new HomeFragment());
        home.commit();
        binding.bottomnav.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                switch (i){
                    case 0:
                        transaction.replace(R.id.content,new HomeFragment());
                        transaction.commit();
                        break;
                    case 1:
                        transaction.replace(R.id.content,new PostFragment());
                        transaction.commit();
                        break;
                    case 2:
                        transaction.replace(R.id.content,new WalletFragment());
                        transaction.commit();
                        break;
                    case 3:
                        transaction.replace(R.id.content,new SettingFragment());
                        transaction.commit();
                        break;
                }

            }
        });
    }
}