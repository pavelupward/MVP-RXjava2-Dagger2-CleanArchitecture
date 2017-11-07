package pavel.bogrecov.omertex.data.repository

import io.reactivex.Observable
import pavel.bogrecov.omertex.data.api.JsonAPI
import pavel.bogrecov.omertex.data.api.PhotoApi
import pavel.bogrecov.omertex.data.model.ExampleModel
import pavel.bogrecov.omertex.data.model.PhotoModel
import pavel.bogrecov.omertex.data.model.Profile

/**
 * Created by pavel on 21.10.2017.
 */

class NetworkRepository(private val jsonAPI: JsonAPI, private val photoApi: PhotoApi
) : INetworkRepository {

    override fun getResponse(): Observable<Array<ExampleModel>> {
        return jsonAPI.allPost
    }

    override fun getPhotoResponse(): Observable<Array<PhotoModel>> {
        return photoApi.allPhoto
    }

    override fun combineObservable(): Observable<Profile>? {
        return null
    }

}
