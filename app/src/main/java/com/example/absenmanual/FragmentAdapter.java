package com.example.absenmanual;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position == 0) {
            MasukFragment masukFragment = new MasukFragment();
            return masukFragment;
        }
        else {
            DaftarFragment daftarFragment = new DaftarFragment();
            return daftarFragment;
        }
    }

    @Override
    public int getItemCount() {

        return 2;
    }
}
