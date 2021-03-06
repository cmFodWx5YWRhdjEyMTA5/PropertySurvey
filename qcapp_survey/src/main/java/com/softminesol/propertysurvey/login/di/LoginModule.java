package com.softminesol.propertysurvey.login.di;


import com.softminesol.propertysurvey.getToken.domain.GetTokenUseCase;
import com.softminesol.propertysurvey.getToken.domain.IGetTokenRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sandeepgoyal on 03/05/18.
 */

@Module
public class LoginModule {

    @Provides
    GetTokenUseCase getTokenUseCase(IGetTokenRepository getTokenRepository) {
        return new GetTokenUseCase(getTokenRepository);
    }

}
