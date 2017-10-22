package pavel.bogrecov.omertex.presentation.mvp.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import pavel.bogrecov.omertex.R;
import pavel.bogrecov.omertex.data.model.Profile;
import pavel.bogrecov.omertex.presentation.app.AppClass;
import pavel.bogrecov.omertex.presentation.mvp.presenter.PresenterMainActivity;

public class MainActivity extends BaseActivity implements IViewMainActivity {

    @Inject
    PresenterMainActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppClass.getNetComponent().inject(this);
        progressBar = (ProgressBar) findViewById(R.id.bar_progress);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterRecyler);
        presenter.setiViewMainActivity(this);
        presenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onLoadList();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showList(List<Profile> exampleModels) {
        addInadapter(exampleModels);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, "Error, retry! " + error + "\n " +
                        getResources().getString(R.string.check_your_internet_connection),
                Toast.LENGTH_LONG).show();


    }
    @Override
    public void showErrorInActivity(){
        TextView error = (TextView)findViewById(R.id.error_text);
        error.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
