package com.github.leoneves.modelobase.view.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {
    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        onCreate();
        return rootView;
    }

    /**
     * Executado logo após ser chamado o onCreateView
     * Utilize este método como ponto de partida do ciclo de vida do Fragment
     * Considere que a View "rootView" já está disponível inflada pela getLayoutId()
     */
    protected void onCreate(){

    }

    /**
     * @return ID do arquivo de layout para este Fragment
     */
    protected int getLayoutId(){
        return -1;
    }
}
