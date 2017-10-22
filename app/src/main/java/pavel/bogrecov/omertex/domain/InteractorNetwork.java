package pavel.bogrecov.omertex.domain;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import pavel.bogrecov.omertex.data.mapper.UserEntityDataMapper;
import pavel.bogrecov.omertex.data.model.ExampleModel;
import pavel.bogrecov.omertex.data.model.PhotoModel;
import pavel.bogrecov.omertex.data.model.Profile;
import pavel.bogrecov.omertex.data.repository.NetworkRepository;

/**
 * Created by pavel on 21.10.2017.
 */

public class InteractorNetwork implements INetworkInteractor {
    private NetworkRepository iNetworkRepository;

    private UserEntityDataMapper userEntityDataMapper;

    public InteractorNetwork(NetworkRepository iNetworkRepository,
            UserEntityDataMapper userEntityDataMapper) {
        this.iNetworkRepository = iNetworkRepository;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<List<ExampleModel>> getResponseFromServer() {
        return iNetworkRepository.getResponse().map((Arrays::asList));
    }

    @Override
    public Observable<List<PhotoModel>> getPhotoResponse() {
        return iNetworkRepository.getPhotoResponse().map((Arrays::asList));

    }

    @Override
    public Observable<List<Profile>> getRezult() {

      return Observable.combineLatest(iNetworkRepository.getPhotoResponse().map(Arrays::asList),
                iNetworkRepository.getResponse().map(Arrays::asList),
                new BiFunction<List<PhotoModel>, List<ExampleModel>, List<Profile>>() {
                    @Override
                    public List<Profile> apply(List<PhotoModel> photoModels,
                            List<ExampleModel> exampleModels) throws Exception {
                        return userEntityDataMapper.
                                transform(exampleModels.subList(exampleModels.size() - 50, exampleModels.size()),
                                photoModels.subList(photoModels.size() - 50, photoModels.size()));
                    }
                });

}
}
