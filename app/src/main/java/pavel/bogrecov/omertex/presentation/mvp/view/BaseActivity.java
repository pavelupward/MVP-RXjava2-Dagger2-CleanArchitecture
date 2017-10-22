package pavel.bogrecov.omertex.presentation.mvp.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import pavel.bogrecov.omertex.R;
import pavel.bogrecov.omertex.data.model.Profile;
import pavel.bogrecov.omertex.presentation.app.AppClass;
import pavel.bogrecov.omertex.presentation.mvp.view.adapter.AdapterRecyler;

/**
 * Created by pavel on 21.10.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected RecyclerView recyclerView;
    protected ProgressBar progressBar;
             @Inject
   protected AdapterRecyler adapterRecyler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,
            @Nullable PersistableBundle persistentState) {
        initDagger();
        super.onCreate(savedInstanceState, persistentState);

    }

    protected void initDagger() {
        AppClass.getNetComponent().inject(this);
    }
    protected void addInadapter(List<Profile> exampleModels){
        adapterRecyler.addItem(exampleModels);
    }

}
