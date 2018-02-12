package pavel.bogrecov.example.data.repository;

import io.reactivex.Observable;
import pavel.bogrecov.example.data.model.ExampleModel;
import pavel.bogrecov.example.data.model.PhotoModel;
import pavel.bogrecov.example.data.model.Profile;

/**
 * Created by pavel on 21.10.2017.
 */

public interface INetworkRepository  {

    Observable<ExampleModel[]> getResponse();
    Observable<PhotoModel[]> getPhotoResponse();
    Observable<Profile> combineObservable();


}
