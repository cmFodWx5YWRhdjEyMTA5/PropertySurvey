package com.softminesol.survey_framework.rolebase.di;

import com.softminesol.survey_framework.rolebase.data.repository.RoleBaseRepository;
import com.softminesol.survey_framework.rolebase.data.repository.datasource.RoleBaseDataFactory;
import com.softminesol.survey_framework.rolebase.domain.IRoleBaseRepository;
import com.softminesol.survey_framework.rolebase.domain.RoleBaseUseCase;

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
