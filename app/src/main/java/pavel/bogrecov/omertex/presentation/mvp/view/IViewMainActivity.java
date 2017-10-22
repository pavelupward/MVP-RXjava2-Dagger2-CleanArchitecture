package pavel.bogrecov.omertex.presentation.mvp.view;

import java.util.List;

import pavel.bogrecov.omertex.data.model.Profile;

/**
 * Created by pavel on 20.10.2017.
 */

public interface IViewMainActivity {
    void showList(List<Profile> exampleModels);

    void showError(String error);

    void hideProgress();

    void showErrorInActivity();

}
