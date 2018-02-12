package pavel.bogrecov.example.domain;

import java.util.List;

import io.reactivex.Observable;
import pavel.bogrecov.example.data.model.ExampleModel;
import pavel.bogrecov.example.data.model.PhotoModel;
import pavel.bogrecov.example.data.model.Profile;

/**
 * Created by pavel on 21.10.2017.
 */

public interface INetworkInteractor {
    Observable<List<ExampleModel>> getResponseFromServer();
    Observable<List<PhotoModel>> getPhotoResponse();
    Observable<List<Profile>> getRezult();


}
