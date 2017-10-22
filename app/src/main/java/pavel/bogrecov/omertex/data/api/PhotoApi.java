package pavel.bogrecov.omertex.data.api;

import io.reactivex.Observable;
import pavel.bogrecov.omertex.data.model.PhotoModel;
import retrofit2.http.GET;

/**
 * Created by pavel on 21.10.2017.
 */

public interface PhotoApi {

    @GET("/list")
    Observable<PhotoModel[]> getAllPhoto();
}
