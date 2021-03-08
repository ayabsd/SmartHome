package com.moduloTech.smarthome.di
import android.content.Context

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moduloTech.smarthome.data.ApiService
import com.moduloTech.smarthome.data.AppDatabase
import com.moduloTech.smarthome.data.Dao
import com.moduloTech.smarthome.data.local.DataManager
import com.moduloTech.smarthome.data.remote.RemoteDataSource
import com.moduloTech.smarthome.data.repository.DeviceRespository
import com.moduloTech.smarthome.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService) = RemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDao(db: AppDatabase) = db.deviceDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource,
                          localDataSource:Dao) =
        DeviceRespository(remoteDataSource, localDataSource)

    @Singleton
    @Provides
    fun provideDataManager(@ApplicationContext context: Context) = DataManager(context)


}