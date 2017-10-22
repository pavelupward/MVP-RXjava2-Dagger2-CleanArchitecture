/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pavel.bogrecov.omertex.data.mapper;

import java.util.ArrayList;
import java.util.List;

import pavel.bogrecov.omertex.data.model.ExampleModel;
import pavel.bogrecov.omertex.data.model.PhotoModel;
import pavel.bogrecov.omertex.data.model.Profile;

public class UserEntityDataMapper {

    /**
     * in a real project there will be another mapper
     */

    public List<Profile> transform(List<ExampleModel> exampleModels, List<PhotoModel> photoModels) {
        List<Profile> userList = new ArrayList<>();

        for (int i = 0; i < exampleModels.size(); i++) {
            Profile prof = new Profile();
            prof.setExModel(exampleModels.get(i));
            prof.setPhotoModel(photoModels.get(i));
            userList.add(prof);
        }

        return userList;
    }

}
