package com.example.cleanarchitecture.base.mvp;

public interface LoadingView {

    /**
     * Muestra una vista con una barra de progreso que indica un proceso de carga.
     */

    void showLoading();

    /**
     * Ocultar una vista de carga.
     */

    void hideLoading();
}
