package com.softminesol.propertysurvey.rolebase.di;

import com.softminesol.propertysurvey.rolebase.data.repository.RoleBaseRepository;
import com.softminesol.propertysurvey.rolebase.data.repository.datasource.RoleBaseDataFactory;
import com.softminesol.propertysurvey.rolebase.domain.IRoleBaseRepository;
import com.softminesol.propertysurvey.rolebase.domain.RoleBaseUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class RoleBaseModule {
    @Provides
    RoleBaseUseCase getRoleBaseUseCase(IRoleBaseRepository roleBaseRepository) {
        return new RoleBaseUseCase(roleBaseRepository);
    }
    @Provides
    IRoleBaseRepository getRoleBaseRepository(RoleBaseDataFactory roleBaseDataFactory) {
        return new RoleBaseRepository(roleBaseDataFactory);
    }

}
