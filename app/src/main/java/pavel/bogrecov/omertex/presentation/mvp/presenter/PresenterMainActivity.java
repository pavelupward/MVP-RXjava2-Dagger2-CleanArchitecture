package pavel.bogrecov.omertex.presentation.mvp.presenter;

import pavel.bogrecov.omertex.R;
import pavel.bogrecov.omertex.data.mapper.UserEntityDataMapper;
import pavel.bogrecov.omertex.domain.InteractorNetwork;
import pavel.bogrecov.omertex.presentation.mvp.view.IViewMainActivity;
import pavel.bogrecov.omertex.utils.NetworkUtils;
import pavel.bogrecov.omertex.utils.rx.RxSchedulers;

/**
 * Created by pavel on 20.10.2017.
 */

public class PresenterMainActivity implements IPresenterMainActivity {
    private IViewMainActivity iViewMainActivity;
    private InteractorNetwork interactorNetwork;
    private RxSchedulers rxSchedulers;
    private UserEntityDataMapper userEntityDataMapper;

    public PresenterMainActivity(InteractorNetwork interactorNetwork, RxSchedulers rxSchedulers) {

        this.interactorNetwork = interactorNetwork;
        this.rxSchedulers = rxSchedulers;
    }

    public void setiViewMainActivity(IViewMainActivity iViewMainActivity) {
        this.iViewMainActivity = iViewMainActivity;
    }

    @Override
    public void onCreate() {

    }

    /**
     * It is also possible to add Jobservices to check the
     * Internet or re-download the data if the network signal is poor
     */
    @Override
    public void onLoadList() {
        if (NetworkUtils.INSTANCE.isNetworkAvailable()) {
            interactorNetwork.getRezult().subscribeOn(rxSchedulers.io())
                    .observeOn(rxSchedulers.androidThread()).subscribe(lists -> {
                iViewMainActivity.showList(lists);
                iViewMainActivity.hideProgress();

            }, throwable -> iViewMainActivity.showError(throwable.toString()));
        } else {
            iViewMainActivity.showError(String.valueOf(R.string.check_your_internet_connection));
            iViewMainActivity.hideProgress();
            iViewMainActivity.showErrorInActivity();

        }
    }

    @Override
    public void onDestroy() {

    }
}
