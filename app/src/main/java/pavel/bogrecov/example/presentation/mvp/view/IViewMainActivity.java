package pavel.bogrecov.example.presentation.mvp.view;

import java.util.List;

import pavel.bogrecov.example.data.model.Profile;

/**
 * Created by pavel on 20.10.2017.
 */

public interface IViewMainActivity {
    void showList(List<Profile> exampleModels);

    void showError(String error);

    void hideProgress();

    void showErrorInActivity();

}
