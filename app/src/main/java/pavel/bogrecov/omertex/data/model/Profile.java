package pavel.bogrecov.omertex.data.model;

/**
 * Created by pavel on 21.10.2017.
 */

public class Profile {
    private int idProfile;
    private ExampleModel exModel;
    private PhotoModel photoModel;

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public void setExModel(ExampleModel exModel) {
        this.exModel = exModel;
    }

    public void setPhotoModel(PhotoModel photoModel) {
        this.photoModel = photoModel;
    }

    public ExampleModel getExModel() {
        return exModel;
    }

    public PhotoModel getPhotoModel() {
        return photoModel;
    }
}
