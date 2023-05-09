package com.feerka.service;

import java.util.List;

import com.feerka.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
