package com.example.data.repository.datasource.user;

import android.content.Context;

import com.example.data.manager.ISessionManager;
import com.example.data.net.service.IUserService;
import com.example.data.net.service.impl.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

/**
 * Clase encargada de procesar los datos desde un servicio o base de datos
 * dicha clase se instancaria una sola vez y se mantendra mientras la aplicacion este viva
 */

@Singleton
public class UserDataStoreFactory {

    private final Context context;
    private final ISessionManager sessionManager;

    /**
     * Constructor que se le injecta las dependencias que necesita
     *
     * @param context Contexto que necesita contar el SQLite para ser ejecutado
     */

    @Inject
    UserDataStoreFactory(@NonNull Context context, @NonNull ISessionManager sessionManager) {
        this.context = context.getApplicationContext();
        this.sessionManager = sessionManager;
    }

    /**
     * Metodo que crea la clase que obtendra los datos desde el Servicio
     *
     * @return class Clase que se encargara de obtener los datos desde el Servicio
     */

    public UserDataStore createCloudSoap() {
        IUserService service = new UserService(context, "");
        return new UserCloudDataStore(service);
    }

    /**
     * Metodo que crea la clase que obtendra los datos desde el Servicio
     *
     * @return class Clase que se encargara de obtener los datos desde el Servicio
     */

    public UserDataStore createCloud() {
        IUserService service = new UserService(context, sessionManager.getToken());
        return new UserCloudDataStore(service);
    }

    /**
     * Metodo que crea la clase que obtendra los datos desde el SQLite
     *
     * @return class Clase que se encargara de obtener los datos desde el SQLite
     */

    public UserDataStore createDB() {
        return new UserDBDataStore(context);
    }
}
