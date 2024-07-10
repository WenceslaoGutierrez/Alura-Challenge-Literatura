package com.fumoliteratura.literatura.service;

public interface IConversorDatos {
    <T> T obtenerDatos(String json,Class<T> clase);
}
