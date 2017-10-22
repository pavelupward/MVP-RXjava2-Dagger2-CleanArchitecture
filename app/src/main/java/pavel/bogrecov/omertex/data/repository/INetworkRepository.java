package pavel.bogrecov.omertex.data.repository;

import io.reactivex.Observable;
import pavel.bogrecov.omertex.data.model.ExampleModel;
import pavel.bogrecov.omertex.data.model.PhotoModel;
import pavel.bogrecov.omertex.data.model.Profile;

/**
 * Created by pavel on 21.10.2017.
 */

public interface INetworkRepository  {

    Observable<ExampleModel[]> getResponse();
    Observable<PhotoModel[]> getPhotoResponse();
    Observable<Profile> combineObservable();


}
