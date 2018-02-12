package pavel.bogrecov.example.data.api;

import io.reactivex.Observable;
import pavel.bogrecov.example.data.model.ExampleModel;
import retrofit2.http.GET;

/**
 * Created by pavel on 20.10.2017.
 */

public interface JsonAPI {

    @GET("/posts")
    Observable<ExampleModel[]> getAllPost();

}
