package com.faculdade.buddyride.Controllers;

import com.faculdade.buddyride.Entities.User;
import com.faculdade.buddyride.Interfaces.IRepository;
import com.faculdade.buddyride.Repositories.UserRepositoryArrayList;

public class Facade {

    private IRepository<User> mUserRepository;

    private Facade() {
        mUserRepository = UserRepositoryArrayList.getInstance();
    }

    private static class Singleton {
        static final Facade INSTANCE = new Facade();
    }

    public static Facade getInstance() {
        return Singleton.INSTANCE;
    }
}
